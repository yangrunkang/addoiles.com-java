package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.NavSettingsService;

/**
 * 导航栏
 * Created by bla on 10/1/2017.
 */
@Controller
public class NavSettingsController extends BaseController {

    @Autowired
    private NavSettingsService navSettingsService;

    @RequestMapping("/getNavs")
    @ResponseBody
    public Object getNavs(){
        return navSettingsService.getNavs();
    }


}
