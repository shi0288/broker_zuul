package com.xyauto.interact.broker.zuul.exception;

import com.xyauto.interact.broker.zuul.enums.ResultCode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ResultException extends Exception {

    private ResultCode result;

    public ResultException() {
        super();
    }

    public ResultException(ResultCode ret) {
        super(ret.getMessage());
        this.result = ret;
    }

    public ResultCode getResult() {
        return result;
    }

    public void setResult(ResultCode result) {
        this.result = result;
    }
}
