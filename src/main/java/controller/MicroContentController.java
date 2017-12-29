package controller;

import com.addoiles.dto.query.QueryDto;
import com.addoiles.entity.MicroContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "getMicroContentList",method = RequestMethod.POST)
    @ResponseBody
    public Object getMicroContentList(@RequestBody QueryDto queryDto) {
        return microContentService.getList(queryDto);
    }



    @RequestMapping(value = "addMicroContent",method = RequestMethod.POST)
    @ResponseBody
    public Object addMicroContent(@RequestBody MicroContent microContent) {
        return microContentService.insert(microContent);
    }


    @RequestMapping(value = "deleteMicroContent",method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestBody QueryDto queryDto) {
        return microContentService.delete(queryDto.getBusinessId());
    }



}
