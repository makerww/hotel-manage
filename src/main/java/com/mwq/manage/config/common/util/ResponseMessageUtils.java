package com.mwq.manage.config.common.util;

import com.mwq.manage.config.common.enmus.ResultCodeEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * 统一返回数据
 *
 * @author wq
 * @since 2020-08-03
 */
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseMessageUtils<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */

    private String message;

    /**
     * 返回信息
     */

    private T data;


    /**
     * 时间戳
     */

    private Long timestamp = System.currentTimeMillis();


    private ResponseMessageUtils(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 带数据返回
     *
     * @param resultCodeEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseMessageUtils<T> ok(ResultCodeEnum resultCodeEnum, T data) {

        return new ResponseMessageUtils(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), data);
    }

    /**
     * 不带数据返回
     *
     * @param resultCodeEnum
     * @param <T>
     * @return
     */
    public static <T> ResponseMessageUtils<T> ok(ResultCodeEnum resultCodeEnum) {
        return new ResponseMessageUtils(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), "");
    }
}
