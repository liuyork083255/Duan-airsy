package liu.york.controller;

import liu.york.model.JsonModel;
import liu.york.model.UserModel;
import liu.york.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/login")
    public JsonModel login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        JsonModel jsonModel = new JsonModel();
        UserModel userModel = userService.selectUserByUP(username, password);
        if(userModel == null){
            jsonModel.setMsg("");
            jsonModel.setSuccess(false);
            return jsonModel;
        }
        request.getSession().setAttribute("userSession",userModel);
        jsonModel.setSuccess(true);

        try {
            response.sendRedirect("/airsy/frame.html");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return jsonModel;
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public JsonModel updateUser(@RequestBody UserModel userModel, HttpServletRequest request){
        JsonModel json = new JsonModel();
        if(userModel == null){
            json.setMsg("参数获取失败");
            json.setSuccess(false);
            return json;
        }

        UserModel sessionUser = (UserModel)request.getSession().getAttribute("userSession");
        userModel.setInfo(sessionUser.getInfo());
        userModel.setPriority(sessionUser.getPriority());
        userModel.setUserid(sessionUser.getUserid());

        int n = 0;
        try {
            n = userService.updateUser(userModel);
        } catch (Exception e) {
            json.setMsg("更新失败 msg：" + e.getMessage());
            json.setSuccess(false);
            return json;
        }
        if(n == 0) {
            json.setMsg("更新失败");
            json.setSuccess(false);
            return json;
        }
        request.getSession().setAttribute("userSession",userModel);
        json.setSuccess(true);
        return  json;
    }

    @ResponseBody
    @RequestMapping("/getUserInfo")
    public JsonModel getUserInfo(HttpServletRequest request){
        JsonModel json = new JsonModel();
        UserModel sessionUser = (UserModel) request.getSession().getAttribute("userSession");
        sessionUser.setPassword("");
        json.setObj(sessionUser);
        json.setSuccess(true);
        return json;
    }

}
