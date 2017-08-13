package liu.york.interceptor;

import com.alibaba.fastjson.JSON;
import liu.york.model.JsonModel;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/8/13.
 */
public class GlogalInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        Object userSession = request.getSession().getAttribute("userSession");
        if(userSession == null){
            JsonModel json = new JsonModel();
            json.setSuccess(false);
            json.setMsg("你还没有登陆！！！");
            response.getWriter().print(JSON.toJSONString(json));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
