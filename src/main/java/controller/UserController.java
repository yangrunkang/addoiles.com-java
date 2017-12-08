package controller;

import com.addoiles.common.OilConstant;
import com.addoiles.db.cache.Cache;
import com.addoiles.db.cache.CacheManager;
import com.addoiles.dto.req.*;
import com.addoiles.dto.resp.LoginResp;
import com.addoiles.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import java.util.Objects;

/**
 * Created by bla on 9/24/2017.
 */
@Controller
public class UserController extends BaseController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody LoginReq loginReq) {
        LoginResp loginResp = new LoginResp();
        User loginUser = userService.login(loginReq);

        if (Objects.nonNull(loginUser)) {
            loginResp.setUserId(loginUser.getUserId());
            loginResp.setUserName(loginUser.getName());
        }

        return loginResp;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody RegisterReq registerReq) {
        //检查用户是否已经注册
        Integer hasRegister = userService.checkHasRegister(registerReq.getEmail());
        if (hasRegister > 0) {
            return OilConstant.HAS_REGISTERED;//已经注册
        }
        return userService.register(registerReq) > 0;
    }

    @RequestMapping(value = "sendVerificationCode", method = RequestMethod.POST)
    @ResponseBody
    public Object sendVerificationCode(@RequestBody VerificationCodeReq verificationCodeReq) {
        userService.sendVerificationCode(verificationCodeReq);
        return true;
    }

    @RequestMapping(value = "verifyCode", method = RequestMethod.POST)
    @ResponseBody
    public Object verifyCode(@RequestBody ExistsVerifyCodeReq existsVerifyCodeReq) {
        Cache cache = CacheManager.isExists(existsVerifyCodeReq.getEmail());

        if (Objects.isNull(cache)) {
            return false;
        }

        if (cache.getValue().equals(existsVerifyCodeReq.getCode())) {
            //验证完之后移除
            CacheManager.remove(existsVerifyCodeReq.getEmail());
            return true;
        }

        return false;
    }


    @RequestMapping(value = "confirmResetPassword", method = RequestMethod.POST)
    @ResponseBody
    public Object confirmResetPassword(@RequestBody ResetPasswordReq resetPasswordReq) {
       return userService.resetPassword(resetPasswordReq);
    }




}
