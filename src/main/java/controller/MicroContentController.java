package controller;

import com.addoiles.dto.query.QueryMicroContentDto;
import com.addoiles.entity.MicroContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MicroContentService;

import javax.annotation.Resource;

/**
 *  微内容Controller
 * <p>All rights Reserved, Designed By HQYG.</p>
 * @Copyright    Copyright(C) 2017.
 * @Company      HQYG.
 * @author       Yangrunkang
 * @CreateDate   2017/12/22 16:47
 */
@Controller
public class MicroContentController extends BaseController {

    @Resource
    private MicroContentService microContentService;

    @RequestMapping("getMicroContentList")
    @ResponseBody
    public Object getMicroContentList(@RequestBody QueryMicroContentDto queryMicroContentDto) {
        return microContentService.getList(queryMicroContentDto);
    }



    @RequestMapping("addMicroContent")
    @ResponseBody
    public Object addMicroContent(@RequestBody MicroContent microContent) {
        return microContentService.add(microContent);
    }


    @RequestMapping("delMicroContent")
    @ResponseBody
    public Object delMicroContent(@RequestBody MicroContent microContent) {
        return microContentService.delete(microContent.getMicroId());
    }



}
