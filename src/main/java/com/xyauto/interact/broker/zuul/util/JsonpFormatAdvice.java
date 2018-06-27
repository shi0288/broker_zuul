package com.xyauto.interact.broker.zuul.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by shiqm on 2018-03-09.
 */

@ControllerAdvice("com.xyauto.interact.broker.zuul.controller")
public class JsonpFormatAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpFormatAdvice() {
        super("callback","jsonp");
    }
}
