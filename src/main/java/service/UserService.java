package service;

import com.addoiles.dto.LoginReq;
import com.addoiles.dto.RegisterReq;
import com.addoiles.entity.User;

import java.util.List;

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

    /***
     * 检查用户是否已经注册过
     * @param email
     * @return
     */
    Integer checkHasRegister(String email);

    /**
     * 获取用户id和Name
     * @return
     */
    List<User> getUsersOfIdNameList();

}
