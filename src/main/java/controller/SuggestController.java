package controller;

import com.addoiles.entity.Suggest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SuggestService;

import javax.annotation.Resource;

/**
 * Created by bla on 10/3/2017.
 */
@Controller
public class SuggestController extends BaseController {


    @Resource
    private SuggestService suggestService;


    @RequestMapping(value = "suggest", method = RequestMethod.POST)
    @ResponseBody
    public Object suggest(@RequestBody Suggest suggest) {
        suggestService.insert(suggest);
        return 0;
    }


}
