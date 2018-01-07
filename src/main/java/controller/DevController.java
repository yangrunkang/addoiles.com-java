package controller;

import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.db.cache.OilCache;
import com.addoiles.db.dao.FirstPageMapper;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.entity.FirstPage;
import com.addoiles.util.OilUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    private OilCache oilCache;
    /**
     *  清除开发Redis Key
     * @return
     */
    @RequestMapping(value = "cleanRedisDevData",method = RequestMethod.GET)
    @ResponseBody
    public Object cleanRedisDevData(){
        redisService.deleteKeys(OilRedisConstant.OIL_WEBSITE + "*");
        logger.info("------>dev redis data cleaned");
        return "dev redis data cleaned";
    }


    @Resource
    private FirstPageMapper firstPageMapper;

    /**
     * 添加首页展示信息
     * @param file 这种格式:fileType_fileName_file_desc
     * @return
     */
    @RequestMapping(value = "addFirstPage",method = RequestMethod.POST)
    @ResponseBody
    public Object addFirstPage(@RequestBody MultipartFile file) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        // 通过base64来转化图片
        String data = encoder.encode(file.getBytes());
        String fileName = file.getOriginalFilename();
        String[] split = fileName.split("_");
        String type = split[0];
        String title = split[1];
        String content = split[2];

        FirstPage firstPage = new FirstPage();
        firstPage.setShowId(OilUtils.generateID());
        firstPage.setTitle(title);
        firstPage.setContent(content);
        firstPage.setImage("data:image/jpg;base64," + data);
        firstPage.setType(Integer.valueOf(type));
        firstPage.setDeleteStatus(DBFieldEnum.FirstPageDeleteStatus.NORMAL.getValue());

        Integer insert = firstPageMapper.insert(firstPage);

        return "----> addFirstPage result:" + insert;
    }


    /**
     *  刷新首页图片
     * @return
     */
    @RequestMapping(value = "refreshFistPageImage",method = RequestMethod.GET)
    @ResponseBody
    public Object refreshFistPageImage(){
        redisService.deleteKeys(OilRedisConstant.FIRST_PAGE_IMAGE);
        logger.info("------>refreshFistPageImage Ok");
        oilCache.cacheFirstPageImage();
        return "refreshFistPageImage Ok";
    }


}
