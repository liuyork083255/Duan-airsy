package liu.york.controller;

import liu.york.model.JsonModel;
import liu.york.model.UserModel;
import liu.york.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public JsonModel login(String username,String password){
        JsonModel jsonModel = new JsonModel();
        UserModel userModel = userService.selectUserByUP(username, password);
        if(userModel == null){
            jsonModel.setMsg("");
            jsonModel.setSuccess(false);
            return jsonModel;
        }
        jsonModel.setSuccess(true);
        return jsonModel;
    }
}
