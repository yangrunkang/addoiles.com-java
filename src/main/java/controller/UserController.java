package controller;

import com.addoiles.common.enums.OilConstant;
import com.addoiles.dto.req.*;
import com.addoiles.dto.resp.LatestResp;
import com.addoiles.dto.resp.LoginResp;
import com.addoiles.entity.Suggest;
import com.addoiles.entity.User;
import com.addoiles.util.OilUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Created by bla on 9/24/2017.
 */
@Controller
public class UserController extends BaseController {


    @Resource
    private UserService userService;

    @Resource
    private ArticleService articleService;

    @Resource
    private MicroContentService microContentService;

    @Resource
    private SuggestService suggestService;

    @Resource
    private QuestionService questionService;

    @Resource
    private OilRedisService oilRedisService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody LoginReq loginReq) {
        LoginResp loginResp = new LoginResp();
        User loginUser = userService.login(loginReq);

        if (Objects.nonNull(loginUser)) {
            loginResp.setUserId(loginUser.getUserId());
            loginResp.setUserName(loginUser.getName());
            //安全验证 tokenId
            loginResp.setTokenId(OilUtils.generateID());
            oilRedisService.setUserTokenId(loginUser.getUserId(),loginResp.getTokenId());
        }

        return loginResp;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody RegisterReq registerReq) {
        //检查用户是否已经注册
        Integer hasRegister = userService.checkHasRegister(registerReq.getEmail());
        if (hasRegister > 0) {
            return OilConstant.HAS_REGISTERED;
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
        String verifyCode = oilRedisService.getVerifyCodeByEmail(existsVerifyCodeReq.getEmail());
        return !StringUtils.isEmpty(verifyCode) && verifyCode.equals(existsVerifyCodeReq.getCode());
    }


    @RequestMapping(value = "confirmResetPassword", method = RequestMethod.POST)
    @ResponseBody
    public Object confirmResetPassword(@RequestBody ResetPasswordReq resetPasswordReq) {
        return userService.resetPassword(resetPasswordReq);
    }


    @RequestMapping(value = "checkHasRegister", method = RequestMethod.GET)
    @ResponseBody
    public Object checkHasRegister(String email) {
        return userService.checkHasRegister(email);
    }

}
