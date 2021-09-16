package com.mwq.manage.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * (Role)
 *
 * @author wq
 * @since 2021-09-16 15:25:45
 */
@ApiModel(value = "(Role)实体类", description = "(Role)实体类")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_role")
public class RoleEntity extends Model<RoleEntity> implements Serializable {


    @TableId(value = "id", type = IdType.ASSIGN_ID)

    private Long id;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    /**
     * 角色权限uri
     */
    @ApiModelProperty(value = "角色权限uri")
    private String roleAuthList;

}