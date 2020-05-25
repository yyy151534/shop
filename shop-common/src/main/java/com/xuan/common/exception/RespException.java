package com.xuan.common.exception;

import com.xuan.common.enums.ErrorCodeEnum;
import lombok.Getter;

@Getter
public class RespException extends RuntimeException{

    private ErrorCodeEnum errorCodeEnum;

    private int code;

    private String msg;

    public RespException(ErrorCodeEnum errorCodeEnum) {
        this(errorCodeEnum, errorCodeEnum.getMsg());
    }

    public RespException(ErrorCodeEnum errorCodeEnum, String msg) {
        this(errorCodeEnum.getCode(), msg);
        this.errorCodeEnum = errorCodeEnum;
    }

    public RespException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
