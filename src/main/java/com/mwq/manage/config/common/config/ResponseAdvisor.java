package com.mwq.manage.config.common.config;

import com.diboot.core.util.V;
import com.mwq.manage.config.common.anno.NotRest;
import com.mwq.manage.config.common.enmus.ResultCodeEnum;
import com.mwq.manage.config.common.util.ResponseMessageUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;

/**
 * <p>
 * 统一REST风格返回
 * 不需要统一返回格式请加@NotRest
 * </p>
 *
 * @author wq
 */
@ControllerAdvice
public class ResponseAdvisor implements ResponseBodyAdvice<Object> {


    /**
     * 不需要封装的url
     * -swagger
     */
    private static final String[] ALLOW_PATH = {
            "/v2/api-docs",
            "/swagger-resources/configuration/ui",
            "/swagger-resources",
            "/swagger-resources/configuration/security",
            "/doc.html",
            "/webjars/**",
            "/api/**/v2/api-docs"
    };

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        String path = request.getURI().getPath();

        //不封装的url
        if (body instanceof ResponseMessageUtils || Arrays.asList(ALLOW_PATH).contains(path)) {
            return body;
        }
        //拥有NotRest注解的不封装
        NotRest methodAnnotation = returnType.getMethodAnnotation(NotRest.class);
        if (!V.isEmpty(methodAnnotation)) {
            return body;
        }
        return ResponseMessageUtils.ok(ResultCodeEnum.OK, body);
    }
}