package controller;

import com.addoiles.dto.TulingReq;
import com.addoiles.dto.TulingResp;
import com.addoiles.util.HttpClientUtil;
import com.addoiles.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bla on 10/2/2017.
 */
@Controller
public class OilRobotController extends BaseController {

    @RequestMapping("chat")
    @ResponseBody
    public Object chat(@RequestBody TulingReq tulingReq) {
        Map<String,String> map = new HashMap<>();
        //key传过来的最后一位是错的,我改了,原本是4
        map.put("key",tulingReq.getKey().substring(0, tulingReq.getKey().length() - 1) + "4");
        map.put("info",tulingReq.getInfo());
        map.put("userid",tulingReq.getUserid());

        String response = HttpClientUtil.sendPost(tulingReq.getApi(),map,"utf-8");
        TulingResp tulingResp = JsonUtils.fromJson(response, TulingResp.class);
        if(tulingResp.getCode() == 40004){
            tulingResp.setText("今天来晚了哦,我每天只能聊天1000次,今天凌晨可以约我");
        }
        return tulingResp.getText();
    }

}
