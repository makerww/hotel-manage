package com.mwq.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.diboot.core.util.V;
import com.mwq.manage.domain.dto.UrlMappingDto;
import com.mwq.manage.domain.entity.RoleEntity;
import com.mwq.manage.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * (Role)
 *
 * @author wq
 * @since 2021-09-16 15:25:45
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("role")
public class RoleController {
    @Resource
    WebApplicationContext applicationContext;
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 所有数据
     *
     * @param roleEntity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "查询所有数据")
    @GetMapping("list")
    public List<RoleEntity> selectAll(RoleEntity roleEntity) {
        return this.roleService.list(new QueryWrapper<>(roleEntity));
    }

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param roleEntity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping("page-list")
    public Page<RoleEntity> selectAllByPage(Page<RoleEntity> page, RoleEntity roleEntity) {
        return this.roleService.page(page, new QueryWrapper<>(roleEntity));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据")
    @GetMapping("{id}")
    public RoleEntity selectOne(@PathVariable Serializable id) {
        return this.roleService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param roleEntity 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public Boolean insert(@RequestBody RoleEntity roleEntity) {
        return this.roleService.save(roleEntity);
    }

    /**
     * 修改数据
     *
     * @param roleEntity 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public Boolean update(@RequestBody RoleEntity roleEntity) {
        return this.roleService.updateById(roleEntity);
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
        return this.roleService.removeByIds(idList);
    }

    @ApiOperation(value = "路径地图")
    @GetMapping("pathMapping")
    public Map<String, List<UrlMappingDto>> getParam() {

        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 拿到Handler适配器中的全部方法
        Map<RequestMappingInfo, HandlerMethod> methodMap = mapping.getHandlerMethods();
        List<UrlMappingDto> urlList = new ArrayList<>();

        methodMap.forEach((k, v) -> {
            UrlMappingDto urlMappingDto = new UrlMappingDto();
            ApiOperation annotation = v.getMethod().getAnnotation(ApiOperation.class);
            Api api = v.getBeanType().getAnnotation(Api.class);
            String parent = V.isEmpty(api) ? v.getBeanType().getSimpleName() : Arrays.toString(api.tags());
            String value = V.isEmpty(annotation) ? "未定义描述" : annotation.value();
            Set<String> urlSet = k.getPatternsCondition().getPatterns();
            // 获取全部请求方式
            Set<RequestMethod> methods = k.getMethodsCondition().getMethods();
            urlMappingDto.setParent(parent);
            urlMappingDto.setDesc(value);
            urlMappingDto.setPath(StringUtils.join(urlSet.toArray(), ","));
            urlMappingDto.setMethod(StringUtils.join(methods.toArray(), ","));
            urlList.add(urlMappingDto);
        });

        return urlList.stream().collect(Collectors.groupingBy(UrlMappingDto::getParent));
    }
}