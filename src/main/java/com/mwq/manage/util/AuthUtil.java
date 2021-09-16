package com.mwq.manage.util;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mwq.manage.config.common.Context;
import com.mwq.manage.domain.entity.RoleEntity;
import com.mwq.manage.domain.entity.UserEntity;

/**
 * <p>
 * ..
 * </p>
 *
 * @author wq
 * @since 2021-09-16 15:26
 **/
public class AuthUtil {
    /**
     * 查询用户
     *
     * @return UserEntity
     */
    public UserEntity getUser() {
        String s = (String) Context.get();
        System.out.println("token:" + s);
        return new UserEntity().selectOne(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getPhone, Integer.parseInt(s)));
    }

    /**
     * 查询角色的权限uri
     *
     * @return auth
     */
    public RoleEntity getUserAuth() {
        UserEntity user = this.getUser();
        return new RoleEntity().selectById(user.getRoleId());
    }
}
