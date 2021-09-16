package com.mwq.manage.config.common.exception;

import com.mwq.manage.config.common.enmus.ResultCodeEnum;
import lombok.Getter;

/**
 * 自定义异常返回
 *
 * @author wq
 * @date 2020-10-15 14:03
 **/
public class MyRunException extends RuntimeException {

    @Getter
    private final ResultCodeEnum resultCodeEnum;

    public MyRunException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
    }
}
