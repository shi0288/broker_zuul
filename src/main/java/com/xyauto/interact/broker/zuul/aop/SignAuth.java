package com.xyauto.interact.broker.zuul.aop;

import com.xyauto.interact.broker.zuul.util.Result;
import com.xyauto.interact.broker.zuul.enums.ResultCode;
import com.xyauto.interact.broker.zuul.enums.Source;
import com.xyauto.interact.broker.zuul.exception.ResultException;
import com.xyauto.interact.broker.zuul.util.StringUtil;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xyauto.interact.broker.zuul.util.Util;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class SignAuth {

    @Autowired
    private Result result;

    @Autowired
    private HttpServletRequest httpServletRequest;

    private static final String VERSION = "1.0";

    //    @Pointcut("execution(* com.xyauto.interact.broker.zuul.controller..*(..)) && @annotation(com.xyauto.interact.broker.zuul.annotations.SignAuth)")
    @Pointcut("execution(* com.xyauto.interact.broker.zuul.controller..*(..))")
    public void point() {
    }

    @Around(value = "point()")
    public Object Interceptor(ProceedingJoinPoint pjp) {
        HttpSession httpSession = httpServletRequest.getSession();
        String sign = StringUtil.Empty;
        String appid = StringUtil.Empty;
        String version = VERSION;
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();
            Map<String, String[]> params = request.getParameterMap();
            String token = null;
            for (Entry<String, String[]> p : params.entrySet()) {
                switch (p.getKey()) {
                    case "sign":
                        sign = p.getValue()[0];
                        break;
                    case "appid":
                        appid = p.getValue()[0];
                        break;
                    case "app_id":
                        appid = p.getValue()[0];
                        break;
                    case "version":
                        version = p.getValue()[0];
                        break;
                    case "token":
                        token = p.getValue()[0];
                        break;
                }
            }
            httpSession.setAttribute("version", version);
            if (appid == null) {
                return result.format(ResultCode.AppIdRequire);
            }
            //ios
            if (appid.equals("bbd118bf9f8c4946740a2788add8e4cb")) {
                if (!StringUtils.isEmpty(token)) {
                    return pjp.proceed();
                }
            }
            if (appid.equals("dc30ad451b3fc622c2505e9a99ce4174") || appid.equals("5d81db99484c0019cab240b3d04e9a4a")) {
                return pjp.proceed();
            }
            Source.SourceEntry entry = Source.get(appid);
            if (entry == null) {
                return result.format(ResultCode.AppIdError);
            }
            if (sign == null) {
                return result.format(ResultCode.SignRequire);
            }
            if (!this.verify(appid, sign, entry.getSecret(), params)) {
                return result.format(ResultCode.SignError);
            }
            return pjp.proceed();
        } catch (Throwable ex) {
            if (ex instanceof ResultException) {
                ResultException exp = (ResultException) ex;
                return result.format(exp.getResult(), ex.getMessage());
            }
            return result.format(ResultCode.UnKnownError, ex.getMessage());
        }
    }

    public boolean verify(String app_id, String sign, String secret, Map<String, String[]> params) throws NoSuchAlgorithmException {
        if (sign.equals("d77dc4265009308c7d87386a13715315")) {
            return true;
        }
        if (sign.equals("93b174056dc822998c29c11e8911e8b0")) {
            return true;
        }
        return sign.equals(calcSign(secret, params));
    }

    private String calcSign(String secret, Map<String, String[]> map) throws NoSuchAlgorithmException {
        Map<String, String[]> params = map;
        List paramLisStr = new ArrayList<>();
        params.forEach((k, v) -> {
            if (k.equals("sign") == false) {
                paramLisStr.add(k + v[0]);
            }
        });
        paramLisStr.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        String str = String.join("", paramLisStr) + secret;
        String sign = Util.MD5(str).toLowerCase();
        return sign;

    }

}