package com.xyauto.interact.broker.zuul.util.interceptor;

import com.alibaba.fastjson.JSON;

import com.xyauto.interact.broker.zuul.enums.ResultCode;
import com.xyauto.interact.broker.zuul.util.Cache;
import com.xyauto.interact.broker.zuul.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserHandlerInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(UserHandlerInterceptor.class);

    @Autowired
    private Cache cache;

    @Autowired
    private Result result;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        return true;
//        /*
//        String token = request.getParameter("token");
//        if (token == null) {
//            token = request.getHeader("token");
//        }
//        if (token == null) {
//            this.returnJson(response, result.format(ResultCode.PARAM_TOKEN_NULL));
//            logger.info("token不能为空 ");
//            return false;
//        }
//        String accountStr = cache.get(token);
//        if (accountStr == null) {
//            logger.info("token无效");
//            this.returnJson(response, result.format(ResultCode.PARAM_TOKEN_ERROR));
//            return false;
//        }
//        return true;*/
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("date", System.currentTimeMillis());
//        request.setAttribute("qianduanDate", new SimpleDateFormat("yyyyMMddHH") .format(new Date() ));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        httpServletRequest.setAttribute("date", System.currentTimeMillis());
    }

    private void returnJson(HttpServletResponse response, Result json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSON.toJSON(json));
        } catch (IOException e) {
            logger.error("response error", e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
