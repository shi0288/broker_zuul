package com.xyauto.interact.broker.zuul.enums;

public enum ResultCode {
    Success(10000, "成功"),
    SignRequire(10001, "缺少sign参数"),
    SignError(10002, "sign校验失败"),
    AppIdRequire(10003, "缺少app_id参数"),
    AppIdError(10004, "app_id校验失败"),
    RateLimit(10005, "接口访问频率限制"),
    PARAM_REQUEST_NONE(10006, "参数不完整"),
    RABBIT_CONTENT_NULL(10007, "content不合法"),
    PARAM_TOKEN_NULL(30001, "token不能为空"),
    PARAM_TOKEN_ERROR(30002, "token无效"),


    UnKnownError(99999, "未知错误"),
    ServiceDown(99998, "服务不可用");

    private final int code;
    private final String message;

    public int getCode() {
        return this.code;
    }
    
    public String getMessage() {
        return this.message;
    }

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
