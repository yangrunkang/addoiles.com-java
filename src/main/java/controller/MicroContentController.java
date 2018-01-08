package controller;

import com.addoiles.common.enums.DBFieldEnum;
import com.addoiles.dto.query.QueryDto;
import com.addoiles.entity.MicroContent;
import com.addoiles.entity.User;
import com.addoiles.impl.ServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MicroContentService;
import service.OilRedisService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 微内容Controller
 * <p>All rights Reserved, Designed By HQYG.</p>
 *
 * @author Yangrunkang
 * @Copyright Copyright(C) 2017.
 * @Company HQYG.
 * @CreateDate 2017/12/22 16:47
 */
@Controller
public class MicroContentController extends BaseController {

    @Resource
    private MicroContentService microContentService;

    @Resource
    private OilRedisService oilRedisService;

    @RequestMapping(value = "getMicroContentList", method = RequestMethod.POST)
    @ResponseBody
    public Object getMicroContentList(@RequestBody QueryDto queryDto) {
        List<MicroContent> microContentList = microContentService.getList(queryDto);

        // 热门动弹 userId 转 userName
        List<MicroContent> hostList = microContentList.stream()
                .filter(microContent -> microContent.getMicroType() == DBFieldEnum.MicroContentType.HOTS.getValue())
                .collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(hostList)){
            List<User> usersOfIdNameList = oilRedisService.getUsersIdsNames(false);
            ServiceUtil.HandleMicroContentUserIdToUserName(microContentList, usersOfIdNameList);
        }

        return microContentList;
    }

    @RequestMapping(value = "getAllDreams", method = RequestMethod.POST)
    @ResponseBody
    public Object getAllDreams() {

        List<MicroContent> microContentList = oilRedisService.getAllDreams();

        // 所有梦想 userId 转 userName
        List<MicroContent> hostList = microContentList.stream()
                .filter(microContent -> microContent.getMicroType() == DBFieldEnum.MicroContentType.HOTS.getValue())
                .collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(hostList)){
            List<User> usersOfIdNameList = oilRedisService.getUsersIdsNames(false);
            ServiceUtil.HandleMicroContentUserIdToUserName(microContentList, usersOfIdNameList);
        }

        return microContentList;
    }


    @RequestMapping(value = "addMicroContent", method = RequestMethod.POST)
    @ResponseBody
    public Object addMicroContent(@RequestBody MicroContent microContent) {
        return microContentService.insert(microContent);
    }


    @RequestMapping(value = "deleteMicroContent", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestBody QueryDto queryDto) {
        return microContentService.delete(queryDto.getBusinessId());
    }


}
