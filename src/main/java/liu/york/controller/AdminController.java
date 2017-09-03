package liu.york.controller;

import liu.york.exception.AirControllerException;
import liu.york.model.DataModel;
import liu.york.model.JsonModel;
import liu.york.model.UsdModel;
import liu.york.model.UserModel;
import liu.york.service.DataService;
import liu.york.service.UsdService;
import liu.york.service.UserService;
import liu.york.util.MailUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/26.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UsdService usdService;
    @Autowired
    private DataService dataService;
    @Autowired
    private MailUtil mailUtil;

    @ResponseBody
    @RequestMapping("/adminLogin")
    public JsonModel adminLogin(String username, String password, HttpServletRequest request){
        JsonModel json = new JsonModel();
        UserModel userModel = userService.selectUserByUP(username, password);
        if(userModel == null)
            throw new AirControllerException("无效的用户名 或 密码");
        if(!userModel.getPriority().equals("0"))
            throw new AirControllerException("你不是管理员权限！");

        request.getSession().setAttribute("userSession",userModel);
        json.setSuccess(true);

        LOGGER.info("admin login success.  username : " + username);
        return json;
    }

    @ResponseBody
    @RequestMapping("/insertSNNumber")
    public JsonModel insertSNNumber(String number){
        LOGGER.info("start begging insertSN number :" + number);
        JsonModel json = new JsonModel();
        int i = usdService.insertSN(number);
        if(i != 1)
            throw new AirControllerException("插入失败！");
        json.setSuccess(true);
        LOGGER.info("insertSN number success.");
        return json;
    }

    @ResponseBody
    @RequestMapping("/setYQM")
    public JsonModel setYQM(HttpServletRequest request,String email,String yqm){
        LOGGER.info("start setting yqm : "  + yqm);
        JsonModel json = new JsonModel();

        if(userService.selectUserByEmail(email) != null){
            throw new AirControllerException("邮箱已被注册！");
        }

        String msg = "您的邀请码是:" + yqm;

        try {
            mailUtil.sendEmil(email,msg);
        } catch (MessagingException e) {
            LOGGER.error("send email to ["  + email + "] fail ,msg : " + e.getMessage());
            throw new AirControllerException("邮件发送失败");
        }

        request.getServletContext().setAttribute(email,yqm);

        json.setSuccess(true);
        json.setMsg("邮件发送成功");
        LOGGER.info("email send to  ["  + email + "] success.");
        return json;
    }

    @ResponseBody
    @RequestMapping("/getDataByDataId")
    public Map<String,Object> getDataById(String dataId,int page,int rows){
        Map<String,Object> map = new HashMap();
        int total = dataService.selectDataTotal();
        List<DataModel> dataModels = dataService.selectDataById(dataId, (page - 1) * rows, rows);
        map.put("total",total);
        map.put("rows",dataModels);
        return map;
    }

    @ResponseBody
    @RequestMapping("/getAllUser")
    public Map<String,Object> getAllUser(int page,int rows){

        List<UserModel> allUser = userService.getAllUser((page-1)*rows,rows);
        int total = userService.selectUserTotal();

        Map<String,Object> map = new HashMap();
        map.put("total",total);
        map.put("rows",allUser);
        return map;
    }

    @ResponseBody
    @RequestMapping("/getAllUsd")
    public Map<String,Object> getAllUsd(int page,int rows){
        int total = usdService.selectUsdTotal();
        List<UsdModel> usdModels = usdService.selectUsd((page-1)*rows, rows);
        Map<String,Object> map = new HashMap();
        map.put("total",total);
        map.put("rows",usdModels);
        return map;
    }
}
