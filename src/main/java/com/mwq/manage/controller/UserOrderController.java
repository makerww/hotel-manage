package com.mwq.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mwq.manage.domain.entity.UserOrderEntity;
import com.mwq.manage.service.UserOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户订单表(UserOrder)用户订单表
 *
 * @author wq
 * @since 2021-09-16 15:40:12
 */
@Api(tags = "用户订单表")
@RestController
@RequestMapping("userOrder")
public class UserOrderController {
    /**
     * 服务对象
     */
    @Resource
    private UserOrderService userOrderService;

    /**
     * 所有数据
     *
     * @param userOrderEntity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "查询所有数据")
    @GetMapping("list")
    public List<UserOrderEntity> selectAll(UserOrderEntity userOrderEntity) {
        return this.userOrderService.list(new QueryWrapper<>(userOrderEntity));
    }

    /**
     * 分页查询所有数据
     *
     * @param page            分页对象
     * @param userOrderEntity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping("page-list")
    public Page<UserOrderEntity> selectAllByPage(Page<UserOrderEntity> page, UserOrderEntity userOrderEntity) {
        return this.userOrderService.page(page, new QueryWrapper<>(userOrderEntity));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据")
    @GetMapping("{id}")
    public UserOrderEntity selectOne(@PathVariable Serializable id) {
        return this.userOrderService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param userOrderEntity 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public Boolean insert(@RequestBody UserOrderEntity userOrderEntity) {
        return this.userOrderService.save(userOrderEntity);
    }

    /**
     * 修改数据
     *
     * @param userOrderEntity 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public Boolean update(@RequestBody UserOrderEntity userOrderEntity) {
        return this.userOrderService.updateById(userOrderEntity);
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
        return this.userOrderService.removeByIds(idList);
    }
}