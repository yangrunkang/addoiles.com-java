package com.addoiles.impl;

import com.addoiles.common.ErrorCode;
import com.addoiles.common.annotations.OilLog;
import com.addoiles.common.enums.AddoilesConstant;
import com.addoiles.db.cache.CacheManager;
import com.addoiles.db.dao.UserMapper;
import com.addoiles.dto.query.QueryDto;
import com.addoiles.dto.req.LoginReq;
import com.addoiles.dto.req.RegisterReq;
import com.addoiles.dto.req.ResetPasswordReq;
import com.addoiles.dto.req.VerificationCodeReq;
import com.addoiles.entity.User;
import com.addoiles.mail.EmailService;
import com.addoiles.mail.dto.Email;
import com.addoiles.mail.dto.Receiver;
import com.addoiles.util.JsonUtils;
import com.addoiles.util.OilUtils;
import com.addoiles.util.PropertyUtils;
import com.addoiles.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private EmailService emailService;

    @OilLog
    @Override
    public User login(LoginReq loginReq) {
        List<User> userList = userMapper.countByEmail(loginReq.getEmail(), OilUtils.encrypt(loginReq.getPassword()));
        if (!CollectionUtils.isEmpty(userList) && userList.size() == 1) {
            return userList.get(0);
        } else {
            logger.error("userList'size is:{},userList：{}", userList.size(), JsonUtils.toJson(userList));
            return null;
        }
    }

    @OilLog
    @Override
    public Integer register(RegisterReq registerReq) {
        User user = new User();
        user.setUserId(OilUtils.generateID());
        user.setName(registerReq.getUserName());
        user.setEmail(registerReq.getEmail());
        user.setPassword(OilUtils.encrypt(registerReq.getPassword()));
        user.setDeleteStatus(0);
        user.setCreateTime(TimeUtil.currentTime());
        return this.insert(user);
    }

    @Override
    public Integer checkHasRegister(String email) {
        return userMapper.checkHasRegister(email);
    }

    @Override
    public List<User> getUsersOfIdNameList() {
        List<User> userIdNames = userMapper.getUsersOfIdNameList();
        return CollectionUtils.isEmpty(userIdNames) ? new ArrayList<>() : userIdNames;
    }


    @Override
    public Integer sendVerificationCode(VerificationCodeReq verificationCodeReq) {
        Email email = new Email();

        String emailTemplate = PropertyUtils.getValue("email.template");

        String verificationCode = OilUtils.generateRandom(6);

        if (verificationCodeReq.getType() - AddoilesConstant.EmailType.FORGET_PASSWORD.getType() == 0) {
            email.setSubject(AddoilesConstant.EmailType.FORGET_PASSWORD.getDesc());
            emailTemplate = emailTemplate
                    .replace("${text}", email.getSubject())
                    .replace("${code}", "验证码:" + verificationCode)
                    .replace("${desc}", "来自 www.addoiles.com 网站");
            email.setContent(emailTemplate);
        } else if (verificationCodeReq.getType() - AddoilesConstant.EmailType.REGISTER.getType() == 0) {
            email.setSubject(AddoilesConstant.EmailType.REGISTER.getDesc());
            emailTemplate = emailTemplate
                    .replace("${text}", email.getSubject())
                    .replace("${code}", "验证码:" + verificationCode)
                    .replace("${desc}", "来自 www.addoiles.com 网站");
            email.setContent(emailTemplate);
        } else {
            throw ErrorCode.PARAMETER_ERROR.getException();
        }

        //放入缓存
        CacheManager.getInstance().setString(verificationCodeReq.getEmail(), verificationCode, 60);

        Receiver receiver = new Receiver();
        receiver.setEmailAddress(verificationCodeReq.getEmail());
        receiver.setName(verificationCodeReq.getEmail());

        email.setReceiver(receiver);
        emailService.sendEmail(email);
        return 0;
    }

    @OilLog
    @Override
    public Integer resetPassword(ResetPasswordReq resetPasswordReq) {

        User user = new User();
        user.setPassword(OilUtils.encrypt(resetPasswordReq.getPassword()));
        user.setEmail(resetPasswordReq.getEmail());

        return userMapper.updatePasswordByEmail(user);
    }

    @Override
    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer delete(String businessId) {
        return null;
    }

    @Override
    public Integer update(User user) {
        return null;
    }

    @Override
    public User getByBusinessId(String businessId) {
        return null;
    }

    @Override
    public List<User> getList(QueryDto queryDto) {
        return null;
    }
}
