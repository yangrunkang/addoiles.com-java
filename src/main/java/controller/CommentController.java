package controller;

import com.addoiles.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;

/**
 * Created by bla on 9/24/2017.
 */
@Controller
public class CommentController extends BaseController{

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "addComment",method = RequestMethod.POST)
    @ResponseBody
    public Object addComment(Comment comment){
        return commentService.addComment(comment);
    }


}
