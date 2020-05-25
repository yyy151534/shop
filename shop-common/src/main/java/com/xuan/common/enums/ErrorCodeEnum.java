package com.xuan.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCodeEnum {

    //成功
    SUCCESS(100000, "成功"),
    //失败
    ERROR(999999, "服务器响应异常"),

    /***************************************************************************************************************
     *                系统级别定义的异常(6位数字，99开头+4位数字（默认从0001开始）)  即比如：990001              ******
     *                                      【定义开始BEGIN】                                                    ******
     * *************************************************************************************************************/
    //系统级别异常
    SERVICE_CALL_FAILED(990001, "服务调用失败！"),
    PARAM_ERROR(990002, "参数错误"),
    TENANT_ERROR(990003, "域名为空"),
    DATASOURCE_ERROR(990004, "未找到对应数据源"),
    TOKEN_NOT_FOUND(990005, "未找到请求凭证，请登录后重试"),
    UNAUHORIZATION(990006, "权限不足"),
    LOGIN_TOKEN_ACCESS_TIME_OUT_PLEASE_TRY_RELOGIN(990007, "访问令牌已过期，请登录后重试"),
    LOGIN_TOKEN_CREATE_ERROR(990008, "访问令牌生成异常"),
    NO_COOKIE(990009,"当前未发现COOKIE"),
    PARAM_JSON_ERROR(990010, "参数json格式错误"),
    PARAM_NULL_ERROR(990011, "参数不能为空"),
    PARAM_FILLING_ERROR(990012, "参数填充异常"),
    IMPORT_EXCEL_FILE_EMPTY(990013,"EXCEL导入的数据行数为0或文件格式错误"),
    IMPORT_EXCEL_FILE_MAXLENGTH(990014,"EXCEL导入的数据行数超过允许的最大行数"),
    IMPORT_EXCEL_MUST_XSSF(990015,"请使用Excel2007+版本,文件格式为.xlsx的文件"),
    UPLOAD_ERROR(990016,"文件上传失败"),
    DICT_INSERT_ERROR(990017,"数据字典新增失败"),
    DICT_UPDATE_ERROR(990018,"数据字典更新失败"),
    DICT_DEL_ERROR(990019,"数据字典删除失败");

    /**
     * 状态码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;
}
