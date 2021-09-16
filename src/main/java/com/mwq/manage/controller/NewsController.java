package com.mwq.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mwq.manage.domain.entity.NewsEntity;
import com.mwq.manage.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 新闻资讯表(News)新闻资讯表
 *
 * @author wq
 * @since 2021-09-16 14:47:30
 */
@Api(tags = "新闻资讯表")
@RestController
@RequestMapping("news")
public class NewsController {
    /**
     * 服务对象
     */
    @Resource
    private NewsService newsService;

    /**
     * 所有数据
     *
     * @param newsEntity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "查询所有数据")
    @GetMapping("list")
    public List<NewsEntity> selectAll(NewsEntity newsEntity) {
        return this.newsService.list(new QueryWrapper<>(newsEntity));
    }

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param newsEntity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping("page-list")
    public Page<NewsEntity> selectAllByPage(Page<NewsEntity> page, NewsEntity newsEntity) {
        return this.newsService.page(page, new QueryWrapper<>(newsEntity));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据")
    @GetMapping("{id}")
    public NewsEntity selectOne(@PathVariable Serializable id) {
        return this.newsService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param newsEntity 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public Boolean insert(@RequestBody NewsEntity newsEntity) {
        return this.newsService.save(newsEntity);
    }

    /**
     * 修改数据
     *
     * @param newsEntity 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public Boolean update(@RequestBody NewsEntity newsEntity) {
        return this.newsService.updateById(newsEntity);
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
        return this.newsService.removeByIds(idList);
    }
}