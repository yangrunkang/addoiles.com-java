package service;

import com.addoiles.dto.LoginReq;
import com.addoiles.dto.RegisterReq;
import com.addoiles.entity.User;

/**
 * Created by bla on 9/24/2017.
 */
public interface UserService {

    /**
     * 登录
     * @param loginReq
     * @return
     */
    User login(LoginReq loginReq);

    /**
     * 注册
     * @param registerReq
     * @return
     */
    Integer register(RegisterReq registerReq);

}
