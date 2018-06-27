package com.xyauto.interact.broker.zuul.util;

import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class Session {

    private HttpSession session = null;

    @Autowired
    public Session() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if (ra != null) {
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            session = sra.getRequest().getSession();
        }
    }

    public String getValue(String key) {
        Optional<String> value = Optional.ofNullable((String) session.getAttribute(key));
        return value.orElse(StringUtil.Empty);
    }

    public void setValue(String key, String value) {
        session.setAttribute(key, value);
    }

}
