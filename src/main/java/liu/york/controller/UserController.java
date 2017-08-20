package liu.york.controller;

import liu.york.exception.AirControllerException;
import liu.york.model.JsonModel;
import liu.york.model.UserModel;
import liu.york.service.UserService;
import liu.york.util.AirsyUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/7/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private static JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private static String sender;

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

    @ResponseBody
    @RequestMapping("/sendMail")
    public JsonModel sendMail(HttpServletRequest request, String emailTarget){
        JsonModel json = new JsonModel();
        if(emailTarget == null){
            json.setMsg("获取邮箱参数失败");
            json.setSuccess(false);
            return json;
        }

        String uuid = AirsyUtil.getUUID().substring(0,7);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(emailTarget);
        message.setSubject("主题：From Airsy email validation");
        message.setText("您的  ");
        try {
            mailSender.send(message);
           throw new AirControllerException("邮件发送失败");
        } catch (MailException e) {
        }

        request.getSession().setAttribute(emailTarget,uuid);

        json.setSuccess(true);
        return json;
    }

}
