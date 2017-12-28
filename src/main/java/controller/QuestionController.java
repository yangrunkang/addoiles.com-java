package controller;

import com.addoiles.dto.query.QueryDto;
import com.addoiles.dto.view.QuestionAnswerDto;
import com.addoiles.entity.Comment;
import com.addoiles.entity.Question;
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
import service.QuestionService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
@Controller
public class QuestionController extends BaseController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getQuestionAnswerList",method = RequestMethod.POST)
    @ResponseBody
    public Object getQuestionAnswerList(@RequestBody QueryDto queryDto) {
        List<QuestionAnswerDto> questionAnswerDtoList = new ArrayList<>();

        List<Question> questionList = questionService.getList(queryDto);

        List<User> usersOfIdNameList = userService.getUsersOfIdNameList();

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


    @RequestMapping(value = "addQuestion", method = RequestMethod.POST)
    @ResponseBody
    public Object addQuestion(@RequestBody Question question) {
        return questionService.insert(question);
    }

    @RequestMapping(value = "getQuestionsByUserId", method = RequestMethod.POST)
    @ResponseBody
    public Object getQuestionsByUserId(@RequestBody QueryDto queryDto) {
        return questionService.getSimpleList(queryDto);
    }

    @RequestMapping(value = "deleteByQuestionId", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteByQuestionId(String questionId) {
        return questionService.delete(questionId);
    }

}
