package com.mwq.manage.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mwq.manage.domain.entity.RoleEntity;
import com.mwq.manage.mapper.RoleMapper;
import com.mwq.manage.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * (Role)表服务实现类
 *
 * @author wq
 * @since 2021-09-16 15:25:45
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

}