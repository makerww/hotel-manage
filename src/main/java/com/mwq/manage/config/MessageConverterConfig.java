package com.mwq.manage.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 * 消息转换处理器
 *
 * @author peikunkun
 * @version V1.0
 * @date 2021-01-06 17:36
 **/
@Configuration
public class MessageConverterConfig {


    /**
     * 使用jackson序列化消息转换
     *
     * @return org.springframework.boot.autoconfigure.http.HttpMessageConverters
     */
    @Bean
    public MappingJackson2HttpMessageConverter fastJsonHttpMessageConverters() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setDefaultCharset(Charset.defaultCharset());

        //@formatter:off
        ObjectMapper objectMapper = new ObjectMapper();
        // 忽略json字符串中不识别的属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 忽略无法转换的对象
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // PrettyPrinter 格式化输出
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        messageConverter.setObjectMapper(objectMapper);


        //支持的媒体类型
        List<MediaType> supportedMediaTypes = new LinkedList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);


        //页面直接请求的类型(这里是新增加的支持的匹配的类型,页面访问的时候类型为text/html)
        supportedMediaTypes.add(MediaType.TEXT_HTML);

        messageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return messageConverter;
    }

}
