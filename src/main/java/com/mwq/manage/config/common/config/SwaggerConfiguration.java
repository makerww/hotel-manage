package com.mwq.manage.config.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.mwq.manage.config.common.enmus.ResultCodeEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wq
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.mwq.manage";
    public static final String VERSION = "1.0.0";

    @Bean(value = "zd-jyh")
    @Order(value = 1)
    public Docket zdJyh() {

        //添加全局响应状态码
        List<Response> responseMessageList = new ArrayList<>();
        Arrays.stream(ResultCodeEnum.values()).forEach(enums -> {
            responseMessageList.add(
                    new Response(enums.getCode() + "", enums.getMessage(), true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
            );
        });
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                // 添加全局响应状态码
                .globalResponses(HttpMethod.GET, responseMessageList)
                .globalResponses(HttpMethod.POST, responseMessageList)
                .globalResponses(HttpMethod.PUT, responseMessageList)
                .globalResponses(HttpMethod.DELETE, responseMessageList)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("zd_group")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                /**设置文档的标题*/
                .title("接口文档")
                /**设置文档的描述*/
                .description("接口文档")
                /**设置文档的联系方式*/
                .contact(new Contact("wq", "", ""))
                /**设置文档的License*/
                .termsOfServiceUrl("zd-power")
                .license("zd-power")
                .licenseUrl("")
                /**设置文档的版本信息-> 1.1 Version information*/
                .version(VERSION)
                .build();
    }


}