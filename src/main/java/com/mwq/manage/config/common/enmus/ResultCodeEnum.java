package com.mwq.manage.config.common.enmus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wq
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResultCodeEnum {

    /*
     *
     * 统一格式：A-BBBB
     *A:错误级别，
     * 0 系统错误
     * 1 第三方错误
     *B:具体错误编号，9999个；
     * */
    /*
     *
     * 统一格式：A-BBBB
     *A:错误级别，
     * 1 系统错误
     * 2 第三方错误
     *B:具体错误编号，9999个；
     * */
    //成功
    OK(1, "成功"),

    FAILED(0, "未定义异常"),

    //基本操做 0-100

    NOT_FOUND_ERROR(10002, "请求路径不存在"),

    USER_REGISTER_ERROR(10003, "用户注册错误"),

    VALIDATE_USERNAME_FAILED(10004, "账号或密码错误"),

    USERNAME_EXISTED(10005, "用户名已存在"),

    ACCESS_FAILED(10006, "权限不足"),

    NOT_LOGIN_IN_FAILED(10007, "未登录"),

    FILE_NOT_FIND(10010, "文件未找到"),

    FAIL_INVALID_TOKEN(10011, "无效的token"),

    FAIL_INVALID_CODE(10012, "无效的code"),

    LOGIN_FAILED(10013, "登录失败"),

    EXCEL_FAILED(10014, "excel错误"),

    FILE_BUILD_FAIL(10015, "文件建立错误"),

    //参数类 101-200
    VALIDATE_TYPE_FAILED(10101, "参数类型验证错误"),

    HTTP_MESSAGE_NOT_READABLE_FAILED(10102, "请求参数应为JSON格式"),

    VALIDATE_FAILED(10103, "参数验证错误"),

    PARAM_FAILED(10104, "参数错误"),


    //数据库类 201-300
    TRAN_FAILED(10201, "事务异常"),

    TRAN_VIOLATION_FAILED(10202, "数据操作失败"),

    DATA_CHANGE_FAILED(100301, "数据转化错误"),

    DATA_EMPTY_FAILED(10302, "数据为空错误"),

    TASK_DEAL_FAILED(10604, "采集任务失败");

    private final Integer code;
    private final String message;


}
