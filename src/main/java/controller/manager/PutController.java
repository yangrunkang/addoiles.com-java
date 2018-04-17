package controller.manager;

import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.dto.business.QueryDto;
import com.addoiles.dto.req.*;
import com.addoiles.dto.resp.TulingResp;
import com.addoiles.entity.*;
import com.addoiles.util.HttpClientUtil;
import com.addoiles.util.JsonUtils;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 增删改操作
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/4/2 19:16
 */
@Controller
public class PutController extends BaseController{

    @Resource
    private MicroContentService microContentService;

    @Resource
    private ArticleService articleService;

    @Resource
    private QuestionService questionService;

    @Resource
    private OilRedisService oilRedisService;

    @Resource
    private SuggestService suggestService;

    /**
     * 删除短内容
     * @param queryDto
     * @return
     */
    @RequestMapping(value = "deleteMicroContent", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteMicroContent(@RequestBody QueryDto queryDto) {
        return microContentService.delete(queryDto.getBusinessId());
    }


    @RequestMapping(value = "updateRates", method = RequestMethod.POST)
    @ResponseBody
    public Object updateRates(@RequestBody RatesDto ratesDto) {

        Article redisArticle = oilRedisService.getArticleByArticleId(ratesDto.getBusinessId());

        Article tmp = new Article();
        tmp.setArticleId(ratesDto.getBusinessId());
        tmp.setUserId(ratesDto.getUserId());
        tmp.setRates(ratesDto.getRate() + redisArticle.getRates());
        tmp.setRateCount(redisArticle.getRateCount() + 1);

        redisArticle.setRates(tmp.getRates());
        redisArticle.setRateCount(tmp.getRateCount());
        oilRedisService.updateArticle(redisArticle);

        return articleService.update(tmp);
    }

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    @ResponseBody
    public Object addComment(@RequestBody CommentReq commentReq) {

        Comment comment = new Comment();

        comment.setUserId(commentReq.getUserId());
        comment.setTargetId(commentReq.getTargetId());
        comment.setContent(commentReq.getContent());

        comment.setCommitId(OilUtils.generateID());
        comment.setDeleteStatus(0);
        comment.setCreateTime(TimeUtil.currentTime());

        return commentService.insert(comment);
    }

    @RequestMapping(value = "deleteByQuestionId", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteByQuestionId(@RequestBody QueryDto queryDto) {
        return questionService.delete(queryDto.getBusinessId());
    }

    @RequestMapping(value = "addQuestion", method = RequestMethod.POST)
    @ResponseBody
    public Object addQuestion(@RequestBody QuestionReq questionReq) {

        Question question = new Question();
        question.setUserId(questionReq.getUserId());
        question.setType(questionReq.getType());
        question.setContent(questionReq.getContent());


        question.setQuestionId(OilUtils.generateID());
        question.setCreateTime(TimeUtil.currentTime());
        question.setDeleteStatus(0);
        return questionService.insert(question);
    }

    @RequestMapping(value = "addSuggest", method = RequestMethod.POST)
    @ResponseBody
    public Object suggest(@RequestBody Suggest suggest) {
        suggestService.insert(suggest);
        //todo 异步发送业务邮件同意方法
        return 0;
    }

    @RequestMapping(value = "addMicroContent", method = RequestMethod.POST)
    @ResponseBody
    public Object addMicroContent(@RequestBody MicroContentReq microContentReq) {

        MicroContent microContent = new MicroContent();

        microContent.setUserId(microContentReq.getUserId());
        microContent.setTitle(microContentReq.getTitle());
        microContent.setContent(microContentReq.getContent());
        microContent.setMicroType(microContentReq.getMicroType());

        microContent.setMicroId(OilUtils.generateID());
        microContent.setLikes(0);
        microContent.setDeleteStatus(DBFieldEnum.MicroContentDeleteStatus.NORMAL.getValue());
        microContent.setCreateTime(TimeUtil.currentTime());

        return microContentService.insert(microContent);
    }

    @RequestMapping("addChat")
    @ResponseBody
    public Object chat(@RequestBody TulingReq tulingReq) {
        Map<String, String> map = new HashMap<>(3);
        //key传过来的最后一位是错的,我改了,原本是4
        map.put("key", tulingReq.getKey().substring(0, tulingReq.getKey().length() - 1) + "4");
        map.put("info", tulingReq.getInfo());
        map.put("userid", tulingReq.getUserId());

        String response = HttpClientUtil.sendPost(tulingReq.getApi(), map, "utf-8");
        TulingResp tulingResp = JsonUtils.fromJson(response, TulingResp.class);
        if (tulingResp.getCode() == 40004) {
            tulingResp.setText("今天来晚了哦,我每天只能聊天1000次,今天凌晨可以约我");
        }
        return tulingResp.getText();
    }

}
