package liu.york.controller;

import com.alibaba.fastjson.JSON;
import liu.york.model.JsonModel;
import liu.york.model.UsdModel;
import liu.york.model.UserModel;
import liu.york.service.UsdService;
import liu.york.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/22.
 */
@Controller
@RequestMapping("/usd")
public class UsdController {

    @Autowired
    private UsdService usdService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/selectUsdByUserId")
    public Object selectUsdByUserId(HttpServletRequest request){
        JsonModel jsonModel = new JsonModel();
        UserModel sessionUser = (UserModel)request.getSession().getAttribute("userSession");
//        List<UsdModel> usdModels = usdService.selectUsdByUserId(sessionUser.getUserid());
        List<UsdModel> usdModels = usdService.selectUsdByUserId(1);

        Map<String,UsdModel> map = new HashMap<>();
        usdModels.forEach((model) -> {
            map.put(String.valueOf(model.getSnid()),model);
        });

        jsonModel.setSuccess(true);
        jsonModel.setObj(usdModels);
        return map;
    }

    @ResponseBody
    @RequestMapping("/insertUsd")
    public JsonModel insertUsd(@RequestBody UsdModel usdModel, HttpServletRequest request){
        JsonModel json = new JsonModel();

        System.out.println(JSON.toJSONString(usdModel));

        if(usdModel == null){
            json.setSuccess(false);
            json.setMsg("获取参数失败");
            return json;
        }

//        UserModel userSession = (UserModel)request.getSession().getAttribute("userSession");
//        usdModel.setUserid(userSession.getUserid());

        usdModel.setUserid("1");

        int i = usdService.insertUsd(usdModel);
        if(i == 1){
            json.setSuccess(true);
            json.setObj(usdModel);
        }else{
            json.setSuccess(false);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/updateUsd")
    public JsonModel updateUsd(@RequestBody UsdModel usdModel){
        JsonModel json = new JsonModel();
        if(usdModel == null){
            json.setSuccess(false);
            json.setMsg("get param fail");
            return json;
        }

        int i = usdService.updateUsd(usdModel);
        if(i == 1){
            json.setSuccess(true);
        }else{
            json.setSuccess(false);
            json.setMsg("update fail");
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/deleteUsd")
    public JsonModel deleteUsd(String snid){
        JsonModel json = new JsonModel();
        if(snid == null){
            json.setSuccess(false);
            json.setMsg("get param fail");
            return json;
        }
        int i = usdService.deleteUsd(snid);

        if(i == 1){
            json.setSuccess(true);
        }else{
            json.setSuccess(false);
            json.setMsg("delete fail");
        }
        return json;
    }
}