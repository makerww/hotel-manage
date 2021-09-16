package com.mwq.manage.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户订单表(UserOrder)用户订单表
 *
 * @author wq
 * @since 2021-09-16 15:40:12
 */
@ApiModel(value = "用户订单表(UserOrder)实体类", description = "用户订单表(UserOrder)实体类")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_user_order")
public class UserOrderEntity extends Model<UserOrderEntity> implements Serializable {


    @TableId(value = "id", type = IdType.ASSIGN_ID)

    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 房间Id
     */
    @ApiModelProperty(value = "房间Id")
    private Integer roomId;
    /**
     * 租聘时间
     */
    @ApiModelProperty(value = "租聘时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rentTime;
    /**
     * 房间快照
     */
    @ApiModelProperty(value = "房间快照")
    private String roomSnapshot;
    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private Double price;
    /**
     * 状态 -1=失效0=未付款 1=已付款
     */
    @ApiModelProperty(value = "状态 -1=失效0=未付款 1=已付款")
    private Integer status;

}