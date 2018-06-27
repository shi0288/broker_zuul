package com.xyauto.interact.broker.zuul.util.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebInterceptor extends WebMvcConfigurerAdapter {


    @Bean
    public UserHandlerInterceptor getUserHandlerInterceptor(){
        return new UserHandlerInterceptor();
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getUserHandlerInterceptor()).
                addPathPatterns("/**")
                .excludePathPatterns(
                        "/user/getLoginCode",
                        "/user/login",
                        "/user/superLogin",
                        "/user/smslogin",
                        "/user/changeNewPwd",
                        "/user/checkMobileCode",
                        "/user/logout",
                        "/user/backPwd/verifyAccount",
                        "/user/backPwd/resetPwd",
                        "/user/backPwd/backPwdCheckEmail",
                        "/user/backPwd/sendEmail",
                        "/user/notNeedLogin/sendSmsCode",
                        "/members/add",
                        "/sms/sendVerifyCode",
                        "/third/**",
                        "/dealer/vitality/**", // 经销商活跃度，开发需要，临时跳过验证 TODO 20180223,
                        "/api/**", //内部服务调用前缀，不需要验证token
                        "/applyForCash/uploadFile"//文件上传
                );
    }
}
