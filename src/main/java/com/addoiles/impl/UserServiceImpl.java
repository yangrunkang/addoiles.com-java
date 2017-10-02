package com.addoiles.impl;

import com.addoiles.dao.UserMapper;
import com.addoiles.dto.LoginReq;
import com.addoiles.dto.LoginResp;
import com.addoiles.entity.User;
import com.addoiles.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(LoginReq loginReq) {
        List<User> userList = userMapper.countByEmail(loginReq.getEmail(),loginReq.getPassword());
        if(!CollectionUtils.isEmpty(userList) && userList.size() == 1){
            return userList.get(0);
        }else{
            logger.error("userList'size is:{},userList：{}",userList.size(), JsonUtils.toJson(userList));
            return null;
        }
    }

}
