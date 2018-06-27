package com.xyauto.interact.broker.zuul.util.filter;

import com.xyauto.interact.broker.zuul.util.cons.CorsCons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shiqm on 2017-08-11.
 */

@Component
public class CorsFilter implements Filter {


    @Autowired
    private CorsCons contains;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String originHeader = httpServletRequest.getHeader("Origin");
        if (contains.getAllowed_origins().contains(originHeader)) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "*");
            response.addHeader("Access-Control-Max-Age", "100");
            response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,token");
            response.addHeader("Access-Control-Allow-Credentials", "false");
            filterChain.doFilter(servletRequest, response);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "*");
//        response.addHeader("Access-Control-Max-Age", "100");
//        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,token");
//        response.addHeader("Access-Control-Allow-Credentials", "false");
//        filterChain.doFilter(servletRequest, response);


    }

    @Override
    public void destroy() {
    }
}
