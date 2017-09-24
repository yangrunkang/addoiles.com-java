package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.HotsService;

import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Controller
public class HotsController {

    @Autowired
    private HotsService hotsService;

    @RequestMapping("getLatestHots")
    @ResponseBody
    public List getLatestHots(){
        return hotsService.getLatestHots();
    }

}
