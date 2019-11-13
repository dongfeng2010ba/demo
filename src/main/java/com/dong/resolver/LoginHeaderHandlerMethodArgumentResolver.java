package com.dong.resolver;

import com.dong.annotation.Header;
import com.dong.demo.vo.LoginHeader;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class LoginHeaderHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    /*@Autowired
    private UserService userService;*/

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(LoginHeader.class) && parameter.hasParameterAnnotation(Header.class);
//        return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
        //获取头里面的信息
        LoginHeader loginHeader = new  LoginHeader();
        loginHeader.setAuthorization(request.getHeader("Authorization"));
        loginHeader.setTenant(request.getHeader("Tenant"));
        System.out.println("loginHeader.getLoginHeader()========>"+loginHeader.getLoginHeader());
        return loginHeader;
    }

}
