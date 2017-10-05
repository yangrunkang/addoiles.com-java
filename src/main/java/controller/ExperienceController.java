package controller;

import com.addoiles.common.Page;
import com.addoiles.dto.ExperienceDto;
import com.addoiles.dto.ExperienceRateReq;
import com.addoiles.entity.Comment;
import com.addoiles.entity.Experience;
import com.addoiles.entity.User;
import com.addoiles.impl.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;
import service.ExperienceService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Controller
public class ExperienceController extends BaseController {

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "addExperience", method = RequestMethod.POST)
    @ResponseBody
    public Object addExperience(@RequestBody Experience experience) {
        return experienceService.addExperience(experience);
    }

    @RequestMapping(value = "getExperienceList", method = RequestMethod.GET)
    @ResponseBody
    public Object getExperienceList(Page page) {
        List<ExperienceDto> experienceDtoList = new ArrayList<>();

        List<User> usersOfIdNameList = userService.getUsersOfIdNameList();
        List<Experience> experienceList = experienceService.selectExperienceList(page);

        if (CollectionUtils.isEmpty(experienceList)) {
            return experienceDtoList; //在页面上显示空
        } else {
            //处理userId转userName
            ServiceUtil.HandleExperienceUserIdToUserName(experienceList,usersOfIdNameList);
            experienceList.forEach(experience -> {
                List<Comment> commentList = commentService.getCommentListByTargetId(experience.getExperienceId());
                if (!CollectionUtils.isEmpty(commentList)) {
                    ExperienceDto experienceDto = new ExperienceDto();
                    experienceDto.setExperience(experience);
                    //处理userId转userName
                    ServiceUtil.HandleCommentUserIdToUserName(commentList, usersOfIdNameList);
                    experienceDto.setCommentList(commentList);
                    experienceDtoList.add(experienceDto);
                } else {
                    ExperienceDto experienceDto = new ExperienceDto();
                    experienceDto.setExperience(experience);
                    experienceDto.setCommentList(new ArrayList<>());
                    experienceDtoList.add(experienceDto);
                }
                //设定评分
                Integer rates = experience.getRates();
                Integer rateCount = experience.getRateCount();
                if (rateCount > 0) {
                    experience.setRates(rates / rateCount > 5 ? 5 : rates / rateCount);
                }

            });
        }
        return experienceDtoList;
    }

    @RequestMapping(value = "updateRates", method = RequestMethod.POST)
    @ResponseBody
    public Object updateRates(@RequestBody ExperienceRateReq experienceRateReq) {
        return experienceService.updateRates(experienceRateReq.getExperienceId(), experienceRateReq.getRate());
    }


}
