package com.mwq.manage.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mwq.manage.domain.entity.UserOrderEntity;
import com.mwq.manage.mapper.UserOrderMapper;
import com.mwq.manage.service.UserOrderService;
import org.springframework.stereotype.Service;

/**
 * 用户订单表(UserOrder)表服务实现类
 *
 * @author wq
 * @since 2021-09-16 15:40:12
 */
@Service("userOrderService")
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrderEntity> implements UserOrderService {

}