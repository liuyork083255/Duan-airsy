package liu.york.exception;

import com.alibaba.fastjson.JSON;
import liu.york.model.JsonModel;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/13.
 */
@ControllerAdvice
@ResponseBody
public class GlobalException {
    private static Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(value=AirControllerException.class)
    public Object getControllerException(AirControllerException e){
        logger.error("from ControllerException, msg : " + e.getMessage());
        JsonModel json = new JsonModel();
        json.setSuccess(false);
        json.setMsg(e.getMessage());
        return json;
    }

    @ExceptionHandler(value=AirServiceException.class)
    public Object getServiceException(AirServiceException e){
        logger.error("from ServiceException , msg : " + e.getMessage());
        JsonModel json = new JsonModel();
        json.setSuccess(false);
        json.setMsg(e.getMessage());
        return json;
    }

    @ExceptionHandler(value = BindException.class)
    public Object getBindException(BindException e){
        String msg = null;
        try {
            msg = e.getAllErrors().get(0).getDefaultMessage();
        } catch (Exception e1) {
            logger.error(msg);
            return new JsonModel(false,"获取 sn 校验失败message 失败",null);
        }
        logger.error("sn 数据校验失败" + msg);
        return  new JsonModel(false,msg,null);
    }

    @ExceptionHandler(value=Exception.class)
    public Object getException(Exception e){
        logger.error("from Exception , msg : " + e.getMessage());
        JsonModel json = new JsonModel();
        json.setSuccess(false);
        json.setMsg("操作异常");
        return json;
    }
}
