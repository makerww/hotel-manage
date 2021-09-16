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
 * 用户表(User)用户表
 *
 * @author wq
 * @since 2021-09-15 18:11:39
 */
@ApiModel(value = "用户表(User)实体类", description = "用户表(User)实体类")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_user")
public class UserEntity extends Model<UserEntity> implements Serializable {


    @TableId(value = "uid", type = IdType.ASSIGN_ID)

    private Long uid;

    /**
     * 电话号码(登录账户)
     */
    @ApiModelProperty(value = "电话号码(登录账户)")
    private Integer phone;
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String pwd;

    /**
     * 角色Id
     */
    @ApiModelProperty(value = "角色Id")
    private Long roleId;

}