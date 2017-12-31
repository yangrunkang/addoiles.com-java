package service;

import com.addoiles.BaseService;
import com.addoiles.dto.req.LoginReq;
import com.addoiles.dto.req.RegisterReq;
import com.addoiles.dto.req.ResetPasswordReq;
import com.addoiles.dto.req.VerificationCodeReq;
import com.addoiles.entity.User;

/**
 * Created by bla on 9/24/2017.
 */
public interface UserService extends BaseService<User> {

    /**
     * 登录
     *
     * @param loginReq
     * @return
     */
    User login(LoginReq loginReq);

    /**
     * 注册
     *
     * @param registerReq
     * @return
     */
    Integer register(RegisterReq registerReq);

    /***
     * 检查用户是否已经注册过
     * @param email
     * @return
     */
    Integer checkHasRegister(String email);

    /**
     * 发送验证码到邮箱
     *
     * @param verificationCodeReq req
     * @return
     */
    Integer sendVerificationCode(VerificationCodeReq verificationCodeReq);

    /**
     * 重设密码
     * @param resetPasswordReq req
     * @return
     */
    Integer resetPassword(ResetPasswordReq resetPasswordReq);


}
