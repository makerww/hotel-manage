package com.mwq.manage.config.common.exception;


import com.mwq.manage.config.common.enmus.ResultCodeEnum;
import com.mwq.manage.config.common.util.ResponseMessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wq
 */
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseMessageUtils handleException(Exception e) {

        log.error("↓---------------错误摘要-----------------↓");
        AtomicInteger index = new AtomicInteger();
        Arrays.stream(e.getStackTrace()).forEach(cu -> {
            if (cu.isNativeMethod()) {
                StackTraceElement stackTraceElement = e.getStackTrace()[index.get() - 1];
                log.error("File---------" + stackTraceElement.getFileName());
                log.error("Line---------" + stackTraceElement.getLineNumber());
                log.error("Method-------" + stackTraceElement.getMethodName());
                log.error("PATH---------" + stackTraceElement);
            }
            index.getAndIncrement();
        });
        log.error("Message------" + e.getMessage());
        log.error("↑--------------------------------↑");
        return ResponseMessageUtils.ok(ResultCodeEnum.FAILED, e.getMessage());
    }

    /**
     * 自定义异常信息
     *
     * @return
     */
    @ExceptionHandler(MyRunException.class)
    public ResponseMessageUtils<String> myRunException(MyRunException errors) {
        return ResponseMessageUtils.ok(errors.getResultCodeEnum(), errors.getMessage());
    }


    /**
     * 参数验证
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseMessageUtils<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        e.printStackTrace();
        List<String> errors = new ArrayList<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        return ResponseMessageUtils.ok(ResultCodeEnum.VALIDATE_FAILED, String.join("!", errors));
    }

    /**
     * 参数验证
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseMessageUtils BindException(BindException e) {
        e.printStackTrace();
        List<String> errors = new ArrayList<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        return ResponseMessageUtils.ok(ResultCodeEnum.VALIDATE_FAILED, String.join(";", errors));
    }

    /**
     * 404 没有找到路径
     *
     * @return
     */

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseMessageUtils handlerNoFoundException(NoHandlerFoundException e, HttpServletResponse response) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        e.printStackTrace();
        return ResponseMessageUtils.ok(ResultCodeEnum.NOT_FOUND_ERROR);
    }

    /**
     * Insert或Update数据时违反了完整性，例如违反了惟一性限制
     *
     * @return
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Object tranException(DataIntegrityViolationException e) {
        e.printStackTrace();
        return ResponseMessageUtils.ok(ResultCodeEnum.TRAN_VIOLATION_FAILED, "数据库操作异常");
    }

    /**
     * 类型错误
     *
     * @param errors
     * @return
     */
    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseMessageUtils UnexpectedTypeException(UnexpectedTypeException errors) {
        errors.printStackTrace();
        return ResponseMessageUtils.ok(ResultCodeEnum.VALIDATE_TYPE_FAILED, errors.toString());
    }


    /**
     * http请求错误
     * 请求不是json格式
     *
     * @param errors
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseMessageUtils HttpMessageNotReadableException(Exception errors) {
        errors.printStackTrace();
        return ResponseMessageUtils.ok(ResultCodeEnum.HTTP_MESSAGE_NOT_READABLE_FAILED, errors.toString());
    }

    /**
     * 参数验证
     *
     * @param errors
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseMessageUtils ConstraintViolationException(ConstraintViolationException errors) {
        errors.printStackTrace();
        return ResponseMessageUtils.ok(ResultCodeEnum.VALIDATE_FAILED, errors.toString());
    }


}
