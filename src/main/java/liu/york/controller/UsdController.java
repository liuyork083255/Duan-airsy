package liu.york.controller;

import com.alibaba.fastjson.JSON;
import liu.york.model.JsonModel;
import liu.york.model.UsdModel;
import liu.york.model.UserModel;
import liu.york.service.UsdService;
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
    public void insertUsd(@RequestBody UsdModel usdModel){
        System.out.println(usdModel);
    }


}
