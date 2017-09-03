package liu.york.config;

import liu.york.interceptor.GlogalInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/8/13.
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new GlogalInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/signout").
                excludePathPatterns("/login").
                excludePathPatterns("/admin/adminLogin").
                excludePathPatterns("/dataEntry/coming").
                excludePathPatterns("/user/login");
        super.addInterceptors(registry);
    }
}
