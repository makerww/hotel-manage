package com.mwq.manage.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mwq.manage.domain.entity.RoomEntity;
import com.mwq.manage.mapper.RoomMapper;
import com.mwq.manage.service.RoomService;
import org.springframework.stereotype.Service;

/**
 * 房间表(Room)表服务实现类
 *
 * @author wq
 * @since 2021-09-15 18:11:39
 */
@Service("roomService")
public class RoomServiceImpl extends ServiceImpl<RoomMapper, RoomEntity> implements RoomService {

}