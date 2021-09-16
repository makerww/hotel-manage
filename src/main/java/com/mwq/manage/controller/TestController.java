//package com.mwq.manage.controller;
//
//import com.diboot.core.util.V;
//import com.mwq.manage.domain.dto.UrlMappingDto;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import javax.annotation.Resource;
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * <p>
// * ..
// * </p>
// *
// * @author wq
// * @since 2021-08-13 10:37
// **/
//@RestController
//@RequestMapping("/test")
//public class TestController {
//    @Resource
//    WebApplicationContext applicationContext;
//
//    @GetMapping("/getParam")
//    public Map<String, List<UrlMappingDto>> getParam() {
//
//        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
//        // 拿到Handler适配器中的全部方法
//        Map<RequestMappingInfo, HandlerMethod> methodMap = mapping.getHandlerMethods();
//        List<UrlMappingDto> urlList = new ArrayList<>();
//
//        methodMap.forEach((k, v) -> {
//            UrlMappingDto urlMappingDto = new UrlMappingDto();
//            ApiOperation annotation = v.getMethod().getAnnotation(ApiOperation.class);
//            Api api = v.getBeanType().getAnnotation(Api.class);
//            String parent = V.isEmpty(api) ? v.getMethod().getClass().getSimpleName() : Arrays.toString(api.tags());
//            String value = V.isEmpty(annotation) ? "未定义描述" : annotation.value();
//            Set<String> urlSet = k.getPatternsCondition().getPatterns();
//            // 获取全部请求方式
//            Set<RequestMethod> methods = k.getMethodsCondition().getMethods();
//            urlMappingDto.setParent(parent);
//            urlMappingDto.setDesc(value);
//            urlMappingDto.setPath(StringUtils.join(urlSet.toArray(), ","));
//            urlMappingDto.setMethod(StringUtils.join(methods.toArray(), ","));
//            urlList.add(urlMappingDto);
//        });
//
//        return urlList.stream().collect(Collectors.groupingBy(UrlMappingDto::getParent));
//    }
//
//}
