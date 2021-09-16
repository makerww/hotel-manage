package com.mwq.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mwq.manage.domain.entity.UserEntity;
import com.mwq.manage.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(User)用户表
 *
 * @author wq
 * @since 2021-09-15 18:11:39
 */
@Api(tags = "用户表")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 所有数据
     *
     * @param userEntity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "查询所有数据")
    @GetMapping("list")
    public List<UserEntity> selectAll(UserEntity userEntity) {

        return this.userService.list(new QueryWrapper<>(userEntity));
    }

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param userEntity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping("page-list")
    public Page<UserEntity> selectAllByPage(Page<UserEntity> page, UserEntity userEntity) {
        return this.userService.page(page, new QueryWrapper<>(userEntity));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据")
    @GetMapping("{id}")
    public UserEntity selectOne(@PathVariable Serializable id) {
        return this.userService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param userEntity 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public Boolean insert(@RequestBody UserEntity userEntity) {
        return this.userService.save(userEntity);
    }

    /**
     * 修改数据
     *
     * @param userEntity 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public Boolean update(@RequestBody UserEntity userEntity) {
        return this.userService.updateById(userEntity);
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
        return this.userService.removeByIds(idList);
    }
}