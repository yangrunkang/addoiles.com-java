package com.addoiles.impl;

import com.addoiles.db.dao.UserMapper;
import com.addoiles.db.redis.OilRedisConstant;
import com.addoiles.db.redis.dto.UserIDNamesDto;
import com.addoiles.db.redis.inter.RedisService;
import com.addoiles.entity.User;
import com.addoiles.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import service.OilRedisService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/30 16:55
 */
@Service
public class OilRedisServiceImpl implements OilRedisService {

    private static Logger logger = LoggerFactory.getLogger(OilRedisService.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisService redisService;

    @Override
    public List<User> getUsersIdsNames(Boolean reload) {


        String userIdNamesJson = redisService.get(OilRedisConstant.USERS_ID_NAME_LIST);

        // userIdNamesJson 为空 或者 reload 为 true
        if(StringUtils.isEmpty(userIdNamesJson) || reload){
            //删除
            redisService.delete(OilRedisConstant.USERS_ID_NAME_LIST);
            //重新查库
            UserIDNamesDto userIDNamesDto = new UserIDNamesDto();
            userIDNamesDto.setUserIdNames(userMapper.getUsersOfIdNameList());
            redisService.set(OilRedisConstant.USERS_ID_NAME_LIST, JsonUtils.toJson(userIDNamesDto));
            //重新Get
            userIdNamesJson = redisService.get(OilRedisConstant.USERS_ID_NAME_LIST);
        }

        logger.info("redis key:{},value{}",OilRedisConstant.USERS_ID_NAME_LIST,userIdNamesJson);

        UserIDNamesDto userIDNamesDto = JsonUtils.fromJson(userIdNamesJson,UserIDNamesDto.class);

        List<User> userIdNames = userIDNamesDto.getUserIdNames();

        if(CollectionUtils.isEmpty(userIdNames)){
            userIdNames = new ArrayList<>();
        }

        return userIdNames;
    }

    @Override
    public void cacheUserVerifyCode(String email, String code) {
        redisService.setTTL(email,code,60);
        logger.info("already cache user verify code,email:{},code:{}",email,code);
    }

    @Override
    public String getVerifyCodeByEmail(String email) {
        return redisService.get(email);
    }


}
