package quangduy.com.admin.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import quangduy.com.admin.common.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest requests, HttpServletResponse response, Object handler) throws Exception {

        boolean flag = false;

        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();

        //Ignore check url
        flag = Arrays.stream(Constant.FunctionUrl.URL_PATTERN_IGNORE).anyMatch(urlPattern ->{

           return handlerMapping.match(requests, urlPattern) != null;
        });

        //check url allow access
        if(!flag){


        }

        return false;
    }
}
