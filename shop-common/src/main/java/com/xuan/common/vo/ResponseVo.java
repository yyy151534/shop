package com.xuan.common.vo;

import com.xuan.common.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 全局返回类
 * @param <T>
 */
@Data
@AllArgsConstructor
public class ResponseVo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public int code;

    public String msg;

    public T data;

    /**
     * 成功返回
     * 无返回值
     *
     * @param <T> 范型变量
     * @return BaseResp<T>
     */
    public static <T> ResponseVo<T> onSuc() {
        return onSuc(null);
    }

    /**
     * 成功返回
     * 以 data 为返回值
     *
     * @param data 返回值
     * @param <T> 范型变量
     * @return BaseResp<T>
     */
    public static <T> ResponseVo<T> onSuc(T data) {
        return build(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 错误返回
     *
     * @param errorCodeEnum 错误枚举，包含错误码和错误信息
     * @param <T> 范型变量
     * @return BaseResp<T>
     */
    public static <T> ResponseVo<T> onFail(ErrorCodeEnum errorCodeEnum) {
        return onFail(errorCodeEnum.getCode(), errorCodeEnum.getMsg());
    }

    /**
     * 错误返回
     *
     * @param code 错误码
     * @param msg 错误信息
     * @param <T> 范型变量
     * @return BaseResp<T>
     */
    public static <T> ResponseVo<T> onFail(int code, String msg) {
        return build(code, msg, null);
    }

    /**
     * 私有方法，构建统一返回实体
     *
     * @param code code 码
     * @param msg 返回消息
     * @param data 返回数据
     * @param <T> 范型变量
     * @return BaseResp<T>
     */
    private static <T> ResponseVo<T> build(int code, String msg, T data) {
        return new ResponseVo<T>(code, msg, data);
    }
}
