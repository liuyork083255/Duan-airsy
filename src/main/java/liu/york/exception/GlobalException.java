package liu.york.exception;

import liu.york.model.JsonModel;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/13.
 */
@ControllerAdvice
@ResponseBody
public class GlobalException {

    @ExceptionHandler(value=AirControllerException.class)
    public Object getControllerException(HttpServletRequest request,AirControllerException e){
        JsonModel json = new JsonModel();
        json.setSuccess(false);
        json.setMsg(e.getMessage());
        return json;
    }

    @ExceptionHandler(value=AirServiceException.class)
    public Object getControllerException(HttpServletRequest request,AirServiceException e){
        JsonModel json = new JsonModel();
        json.setSuccess(false);
        json.setMsg(e.getMessage());
        return json;
    }

    @ExceptionHandler(value=Exception.class)
    public Object getException(HttpServletRequest request,Exception e){
        JsonModel json = new JsonModel();
        json.setSuccess(false);
        json.setMsg(e.getMessage());
        return json;
    }
}
