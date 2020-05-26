package com.xuan.common.exception;

import com.xuan.common.enums.ErrorCodeEnum;
import com.xuan.common.vo.RespVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RespVo<Object>> handleException(Exception e, HttpServletResponse servletResponse) {
        log.error("RespException", e);
        RespVo<Object> resp;
        HttpStatus status;
        if (e instanceof RespException) {
            status = HttpStatus.OK;
            RespException exception = (RespException) e;
            resp = RespVo.onFail(exception.getCode(), exception.getMessage());
        }else if(e instanceof MethodArgumentNotValidException){
            status = HttpStatus.OK;
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            resp = RespVo.onFail(ErrorCodeEnum.PARAM_ERROR.getCode(),exception.getBindingResult().getFieldError().getDefaultMessage());
        }else if(e instanceof HttpMessageNotReadableException){
            status = HttpStatus.OK;
            resp = RespVo.onFail(ErrorCodeEnum.PARAM_ERROR);
        }else{
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            resp = RespVo.onFail(ErrorCodeEnum.ERROR.getCode(), ErrorCodeEnum.ERROR.getMsg());
        }
        return new ResponseEntity<>(resp, status);
    }
}
