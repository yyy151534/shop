package com.xuan.common.exception;

import com.xuan.common.enums.ErrorCodeEnum;
import com.xuan.common.vo.ResponseVo;
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
    public ResponseEntity<ResponseVo<Object>> handleException(Exception e, HttpServletResponse servletResponse) {
        log.error("RespException", e);
        ResponseVo<Object> resp;
        HttpStatus status;
        if (e instanceof RespException) {
            status = HttpStatus.OK;
            RespException exception = (RespException) e;
            resp = ResponseVo.onFail(exception.getCode(), exception.getMessage());
        }else if(e instanceof MethodArgumentNotValidException){
            status = HttpStatus.OK;
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            resp = ResponseVo.onFail(ErrorCodeEnum.PARAM_ERROR.getCode(),exception.getBindingResult().getFieldError().getDefaultMessage());
        }else if(e instanceof HttpMessageNotReadableException){
            status = HttpStatus.OK;
            resp = ResponseVo.onFail(ErrorCodeEnum.PARAM_ERROR);
        }else{
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            resp = ResponseVo.onFail(ErrorCodeEnum.ERROR.getCode(), ErrorCodeEnum.ERROR.getMsg());
        }
        return new ResponseEntity<>(resp, status);
    }
}
