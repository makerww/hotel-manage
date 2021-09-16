package com.mwq.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mwq.manage.domain.entity.UserEntity;

/**
 * 用户表(User)表服务接口
 *
 * @author wq
 * @since 2021-09-15 18:11:39
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 登录 获取token
     *
     * @param phone    phone
     * @param password password
     * @return token
     */
    String login(String phone, String password);
}