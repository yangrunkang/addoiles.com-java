package controller;

import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.db.cache.OilCache;
import com.addoiles.db.dao.RecommendMapper;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.entity.Recommend;
import com.addoiles.util.OilUtils;
import com.addoiles.util.PropertyUtils;
import com.addoiles.util.TimeUtil;
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

/**
 * Description: Dev 数据清理
 * All rights Reserved, Designed By HQYG
 * @apiNote 统一访问地址: http://ip:port/project_name/cleanRedisDevData
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/1/6 8:58
 */
@Controller
public class DevController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(DevController.class);

    @Resource
    private RedisService redisService;

    @Resource
    private RecommendMapper recommendMapper;

    @Resource
    private OilCache oilCache;

    /**
     *  清除开发Redis Key
     * @return
     */
    @RequestMapping(value = "cleanRedisDevData",method = RequestMethod.GET)
    @ResponseBody
    public Object cleanRedisDevData(){
        redisService.deleteKeys("DEV." + "*");
        logger.info("------>dev redis data cleaned");
        return "dev redis data cleaned";
    }

    /**
     *  刷新推荐信息
     * @return
     */
    @RequestMapping(value = "refreshRecommendInfo",method = RequestMethod.GET)
    @ResponseBody
    public Object refreshRecommendInfo(){
        redisService.deleteKeys(OilRedisConstant.FIRST_PAGE_IMAGE);
        logger.info("------>refreshRecommendInfo Ok");
        oilCache.cacheFirstPageImage();
        return "refreshRecommendInfo Ok";
    }



    /**
     * 图片上传
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadImage",method = RequestMethod.POST)
    @ResponseBody
    public Object uploadImage(@RequestBody MultipartFile file) throws IOException {
        //获取文件名
        String fileName = file.getOriginalFilename();

        //检查是否有配置的文件夹
        String imagePath = PropertyUtils.getValue("images.address");
        logger.info("upload image path:{}",imagePath);
        isMkdirs(new File(imagePath));
        //写磁盘
        File imageFile = new File(imagePath + fileName);
        logger.info("file created path:{}",imagePath+ fileName);
        file.transferTo(imageFile);
        isMakeFile(imageFile);

        //入库
        String imageUrl = PropertyUtils.getValue("images.url");
        Recommend recommend = new Recommend();
        recommend.setShowId(OilUtils.generateID());
        recommend.setImage(imageUrl + "/" + fileName);
        recommend.setDeleteStatus(DBFieldEnum.FirstPageDeleteStatus.NORMAL.getValue());
        recommend.setCreateTime(TimeUtil.currentTime());

        return recommendMapper.insert(recommend);
    }

    @RequestMapping(value = "updateImageInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object updateImageInfo(@RequestBody Recommend recommend) throws IOException {

        int updatedId;
        if(recommend.getId() == null){
            updatedId = recommendMapper.selectMaxId();
        }else{
            updatedId = recommend.getId();
        }


        recommend.setId(updatedId);

        Integer insert = recommendMapper.update(recommend);

        return "更新推荐信息成功:" + insert;
    }

    /**
     * 判断文件是否存在
     * @param file
     */
    private static void isMkdirs(File file) {

        if (file.exists()) {
            logger.info(file.getPath() + " exists");
        } else {
            logger.info(file.getPath() + " not exists, create it ...");
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    private static void isMakeFile(File file) {

        if (file.exists()) {
            logger.info(file.getName() + " exists");
        } else {
            logger.info(file.getName() + " not exists, create it ...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }






}
