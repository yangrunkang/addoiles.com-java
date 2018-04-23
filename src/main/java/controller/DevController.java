package controller;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.db.dao.RecommendMapper;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.entity.Recommend;
import com.addoiles.exception.BusinessException;
import com.addoiles.sync.CacheListener;
import com.addoiles.util.FileUtils;
import com.addoiles.util.OilUtils;
import com.addoiles.util.PropertyUtils;
import com.addoiles.util.TimeUtil;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Description: Dev 数据清理
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @apiNote 统一访问地址: http://ip:port/project_name/cleanRedisDevData
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/1/6 8:58
 */
@Controller
public class DevController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(DevController.class);
    private static List<String> imgSuffixList;
    private static String GIF = ".gif";

    static {
        imgSuffixList = Arrays.asList(".jpg", ".png", ".gif", ".jpeg", ".bmp", ".x-icon");
    }

    @Resource
    private RedisService redisService;
    @Resource
    private RecommendMapper recommendMapper;
    @Resource
    private CacheListener cacheListener;


    /**
     * 清除开发Redis Key
     *
     * @return
     */
    @RequestMapping(value = "cleanRedisDevData", method = RequestMethod.GET)
    @ResponseBody
    public Object cleanRedisDevData() {
        redisService.deleteKeys("DEV." + "*");
        logger.info("------>dev redis data cleaned");
        return "dev redis data cleaned";
    }

    /**
     * 刷新推荐信息
     *
     * @return
     */
    @RequestMapping(value = "refreshRecommendInfo", method = RequestMethod.GET)
    @ResponseBody
    public Object refreshRecommendInfo() {
        redisService.deleteKeys(OilRedisConstant.FIRST_PAGE_IMAGE);
        logger.info("------>refreshRecommendInfo Ok");
        cacheListener.cacheFirstPageImage(null);
        return "refreshRecommendInfo Ok";
    }

    /**
     * 图片上传
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadImage(@RequestBody MultipartFile file) throws IOException {

        if (Objects.isNull(file)) {
            throw new BusinessException(ErrorCode.UPLOAD_FILE_NULL);
        }

        //获取文件名
        String originalFilename = file.getOriginalFilename();

        //检验文件后缀
        String suffix = checkFileSuffix(originalFilename);

        //文件名
        String fileName = OilUtils.generateID() + suffix;

        //创建文件
        Boolean isGif = mkFile(file, suffix, fileName);

        //保存至数据库
        Recommend recommend = saveRecommend(fileName, isGif);

        if (recommend == null) {
            return null;
        }

        return recommend.getImage();
    }

    private Recommend saveRecommend(String fileName, Boolean isGif) {
        String imageUrl = PropertyUtils.getValue("images.url");
        Recommend recommend = new Recommend();
        recommend.setShowId(OilUtils.generateID());
        if (!isGif) {
            recommend.setImage(imageUrl + "/" + "thumbnail." + fileName);
        } else {
            //gif 不加 "thumbnail." 标志
            recommend.setImage(imageUrl + "/" + fileName);
        }
        recommend.setDeleteStatus(DBFieldEnum.FirstPageDeleteStatus.NORMAL.getValue());
        recommend.setCreateTime(TimeUtil.currentTime());

        Integer count = recommendMapper.insert(recommend);
        if (Objects.nonNull(count) && count <= 0) {
            logger.error("uploadImage error,recommend:{}", recommend);
            return null;
        }
        return recommend;
    }

    private String checkFileSuffix(String originalFilename) {
        int dotIndex = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(dotIndex, originalFilename.length());

        if (!imgSuffixList.contains(suffix)) {
            throw new BusinessException(ErrorCode.JUST_SUPPORT_IMAGE);
        }
        return suffix;
    }

    private Boolean mkFile(@RequestBody MultipartFile file, String suffix, String fileName) throws IOException {
        //检查是否有配置的文件夹
        String imagePath = PropertyUtils.getValue("images.address");
        logger.info("upload image path:{}", imagePath);
        FileUtils.isMkdirs(new File(imagePath));
        //写磁盘 fileName系统生成(不用中文)
        File imageFile = new File(imagePath + fileName);
        logger.info("file created path:{}", imagePath + fileName);
        file.transferTo(imageFile);
        FileUtils.isMakeFile(imageFile);

        //是否是gif格式
        Boolean isGif = suffix.equalsIgnoreCase(GIF);
        if (!isGif) {
            try {
                //压缩图片
                Thumbnails.of(imageFile)
                        .scale(1f)
                        .outputQuality(0.9)
                        .toFiles(Rename.PREFIX_DOT_THUMBNAIL);

                FileUtils.deleteFile(imageFile);
            } catch (IOException e) {
                e.printStackTrace();
                throw new BusinessException(ErrorCode.UPLOAD_IMG_FAILED);
            }
        }
        return isGif;
    }

    @RequestMapping(value = "updateImageInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateImageInfo(@RequestBody Recommend recommend) throws IOException {

        int updatedId;
        if (recommend.getId() == null) {
            updatedId = recommendMapper.selectMaxId();
        } else {
            updatedId = recommend.getId();
        }


        recommend.setId(updatedId);

        Integer insert = recommendMapper.update(recommend);

        return "更新推荐信息成功:" + insert;
    }


}
