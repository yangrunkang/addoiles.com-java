package controller;

import com.addoiles.common.Page;
import com.addoiles.entity.Hots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.HotsService;

/**
 * Created by bla on 9/24/2017.
 */
@Controller
public class HotsController extends BaseController{

    @Autowired
    private HotsService hotsService;

    @RequestMapping("getLatestHots")
    @ResponseBody
    public Object getLatestHots(Page page) {
        return hotsService.getLatestHots(page);
    }

    @RequestMapping("addHots")
    @ResponseBody
    public Object addHots(@RequestBody Hots hots){
        return hotsService.addHots(hots);
    }

}
