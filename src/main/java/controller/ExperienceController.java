package controller;

import com.addoiles.entity.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ExperienceService;

/**
 * Created by bla on 9/24/2017.
 */
@Controller
public class ExperienceController extends BaseController{

    @Autowired
    private ExperienceService experienceService;

    @RequestMapping(value = "/addExperience",method = RequestMethod.POST)
    @ResponseBody
    public Object addExperience(Experience experience){
        return experienceService.addExperience(experience);
    }
}
