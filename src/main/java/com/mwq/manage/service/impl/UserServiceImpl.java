package com.mwq.manage.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diboot.core.util.V;
import com.mwq.manage.config.common.enmus.ResultCodeEnum;
import com.mwq.manage.config.common.exception.MyRunException;
import com.mwq.manage.domain.entity.UserEntity;
import com.mwq.manage.mapper.UserMapper;
import com.mwq.manage.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author wq
 * @since 2021-09-15 18:11:39
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public String login(String phone, String password) {
        UserEntity tUser = this.baseMapper.selectOne(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getPhone, phone));
        if (V.isEmpty(tUser) || !V.equals(password, tUser.getPwd())) {
            throw new MyRunException(ResultCodeEnum.VALIDATE_USERNAME_FAILED);
        }
        return tUser.getPhone() + "";
    }
}