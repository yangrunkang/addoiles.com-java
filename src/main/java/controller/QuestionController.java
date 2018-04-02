package controller;

import com.addoiles.dto.business.QueryDto;
import com.addoiles.dto.view.QuestionAnswerDto;
import com.addoiles.entity.Comment;
import com.addoiles.entity.Question;
import com.addoiles.entity.User;
import com.addoiles.impl.ServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;
import service.OilRedisService;
import service.QuestionService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *  QuestionController
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   9/24/2017
 */
@Controller
public class QuestionController extends BaseController {

    @Resource
    private QuestionService questionService;

    @Resource
    private CommentService commentService;

    @Resource
    private OilRedisService oilRedisService;

    @RequestMapping(value = "getQuestionAnswerList",method = RequestMethod.POST)
    @ResponseBody
    public Object getQuestionAnswerList(@RequestBody QueryDto queryDto) {
        List<QuestionAnswerDto> questionAnswerDtoList = new ArrayList<>();

        List<Question> questionList = questionService.getList(queryDto);

        List<User> usersOfIdNameList = oilRedisService.getUsersIdsNames(false);

        questionList.forEach(question -> {
            List<Comment> commentList = commentService.getCommentListByTargetId(question.getQuestionId());
            QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto();
            if (!CollectionUtils.isEmpty(usersOfIdNameList)) {
                //处理Comment userId 转 userName
                ServiceUtil.HandleCommentUserIdToUserName(commentList, usersOfIdNameList);
                //处理Question userId 转 userName
                usersOfIdNameList.forEach(user -> {
                    if (user.getUserId().equals(question.getUserId())) {
                        question.setUserName(user.getName());
                    }
                });
            }

            questionAnswerDto.setQuestion(question);
            questionAnswerDto.setAnswerList(commentList);

            questionAnswerDtoList.add(questionAnswerDto);
        });

        return questionAnswerDtoList;
    }

    @RequestMapping(value = "getQuestionsByUserId", method = RequestMethod.POST)
    @ResponseBody
    public Object getQuestionsByUserId(@RequestBody QueryDto queryDto) {
        return questionService.getSimpleList(queryDto);
    }

}
