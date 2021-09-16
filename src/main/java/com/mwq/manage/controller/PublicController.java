package com.mwq.manage.controller;


import com.mwq.manage.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (public)
 *
 * @author wq
 * @since 2021-09-15 18:11:39
 */
@Api(tags = "public")
@RestController
@RequestMapping("public")
public class PublicController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 用户登录
     *
     * @param phone    phone
     * @param password password
     * @return token
     */
    @ApiOperation("用户登录")
    @PostMapping("login")
    public String login(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        return userService.login(phone, password);
    }
}