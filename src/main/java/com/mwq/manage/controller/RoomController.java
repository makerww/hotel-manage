package com.mwq.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mwq.manage.domain.entity.RoomEntity;
import com.mwq.manage.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 房间表(Room)房间表
 *
 * @author wq
 * @since 2021-09-15 18:11:39
 */
@Api(tags = "房间表")
@RestController
@RequestMapping("room")
public class RoomController {
    /**
     * 服务对象
     */
    @Resource
    private RoomService roomService;

    /**
     * 所有数据
     *
     * @param roomEntity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "查询所有数据")
    @GetMapping("list")
    public List<RoomEntity> selectAll(RoomEntity roomEntity) {
        return this.roomService.list(new QueryWrapper<>(roomEntity));
    }

    @ApiOperation(value = "查询自己租的")
    @GetMapping("list/my")
    public List<RoomEntity> selectByUser(RoomEntity roomEntity) {
        return this.roomService.list(new QueryWrapper<>(roomEntity));
    }

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param roomEntity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping("page-list")
    public Page<RoomEntity> selectAllByPage(Page<RoomEntity> page, RoomEntity roomEntity) {
        return this.roomService.page(page, new QueryWrapper<>(roomEntity));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据")
    @GetMapping("{id}")
    public RoomEntity selectOne(@PathVariable Serializable id) {
        return this.roomService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param roomEntity 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public Boolean insert(@RequestBody RoomEntity roomEntity) {
        return this.roomService.save(roomEntity);
    }

    /**
     * 修改数据
     *
     * @param roomEntity 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public Boolean update(@RequestBody RoomEntity roomEntity) {
        return this.roomService.updateById(roomEntity);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除数据")
    @DeleteMapping
    public Boolean delete(@RequestParam("idList") List<Long> idList) {
        return this.roomService.removeByIds(idList);
    }
}