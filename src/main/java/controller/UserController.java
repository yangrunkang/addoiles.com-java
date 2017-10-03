package controller;

import com.addoiles.dto.LoginReq;
import com.addoiles.dto.LoginResp;
import com.addoiles.dto.RegisterReq;
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
        return userService.register(registerReq) > 0;
    }

}
