package com.addoiles.impl;

import com.addoiles.dao.UserMapper;
import com.addoiles.dto.LoginReq;
import com.addoiles.dto.LoginResp;
import com.addoiles.dto.RegisterReq;
import com.addoiles.entity.User;
import com.addoiles.util.JsonUtils;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public Integer register(RegisterReq registerReq) {
        User user = new User();
        user.setUserId(OilUtils.generateID());
        user.setName(registerReq.getUserName());
        user.setEmail(registerReq.getEmail());
        user.setPassword(registerReq.getPassword());
        user.setDeleteStatus(0);
        user.setCreateTime(TimeUtil.currentTime());
        return userMapper.insert(user);
    }

    @Override
    public Integer checkHasRegister(String email) {
        return userMapper.checkHasRegister(email);
    }

    @Override
    public List<User> getUsersOfIdNameList() {
        List<User> userIdNames = userMapper.getUsersOfIdNameList();
        return CollectionUtils.isEmpty(userIdNames)?new ArrayList<>():userIdNames;
    }
}
