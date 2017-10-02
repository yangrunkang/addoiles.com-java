package service;

import com.addoiles.dto.LoginReq;
import com.addoiles.entity.User;

/**
 * Created by bla on 9/24/2017.
 */
public interface UserService {

    User login(LoginReq loginReq);

}
