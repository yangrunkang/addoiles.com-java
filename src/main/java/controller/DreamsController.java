package controller;

import com.addoiles.common.Page;
import com.addoiles.entity.Dreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.DreamsService;

/**
 * Created by bla on 9/24/2017.
 */
@Controller
public class DreamsController extends BaseController {

    @Autowired
    private DreamsService dreamsService;

    @RequestMapping("getDreams")
    @ResponseBody
    public Object getDreams(@RequestBody Page page) {
        return dreamsService.getDreams(page);
    }

    @RequestMapping(value = "addDream", method = RequestMethod.POST)
    @ResponseBody
    public Object addDream(@RequestBody Dreams dreams) {
        return dreamsService.addDream(dreams);
    }

    @RequestMapping(value = "getDreamsByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Object getDreamsByUserId(String userId) {
        return dreamsService.getDreamsByUserId(userId);
    }

    @RequestMapping(value = "deleteByDreamId", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteByDreamId(String dreamId) {
        return dreamsService.deleteByDreamId(dreamId);
    }

}
