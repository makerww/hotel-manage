package com.mwq.manage.config.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Mvc的配置
 *
 * @author peikunkun
 * @version V1.0
 * @date 2021-01-07 17:46
 **/
@Configuration
public class MessageConverterOrderWebMvcConfigurer implements WebMvcConfigurer {


    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        //方法一:把jackson解析器放在第一位,这样匹配完了之后,就会直接返回;[是否匹配和我们解析器支持的类型有关[supportedMediaTypes]详细见源码
        // org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor#writeWithMessageConverters]
        converters.add(0, mappingJackson2HttpMessageConverter);
    }
}
