package com.clive.common.result;

import com.clive.common.result.ErrorCode;

public enum ResultCode implements ErrorCode {
    SUCCESS(200,"请求成功"),
    FAILED(500,"请求失败"),
    UNAUTHORIZED(401,"没有相关权限"),
    VALIDATE_FAILED(404,"参数校验失败"),
    FORBIDDEN(403,"token已经过期");

    private final long code;
    private final String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
