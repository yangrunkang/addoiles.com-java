package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.OilRedisService;

import javax.annotation.Resource;

/**
 * 导航栏
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   10/1/2017
 */
@Controller
public class NavSettingsController extends BaseController {

    @Resource
    private OilRedisService oilRedisService;

    @RequestMapping("getNavs")
    @ResponseBody
    public Object getNavs() {
        return oilRedisService.getNavList();
    }


}
