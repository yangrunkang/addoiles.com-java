package controller;

import com.addoiles.entity.Suggest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SuggestService;

/**
 * Created by bla on 10/3/2017.
 */
@Controller
public class SuggestController extends BaseController {


    @Autowired
    private SuggestService suggestService;


    @RequestMapping(value = "suggest",method = RequestMethod.POST)
    @ResponseBody
    public Object suggest(@RequestBody Suggest suggest){
        suggestService.suggest(suggest);
        return 0;
    }




}
