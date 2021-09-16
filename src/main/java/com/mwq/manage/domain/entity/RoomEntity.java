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
 * 房间表(Room)房间表
 *
 * @author wq
 * @since 2021-09-15 18:11:39
 */
@ApiModel(value = "房间表(Room)实体类", description = "房间表(Room)实体类")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_room")
public class RoomEntity extends Model<RoomEntity> implements Serializable {


    @TableId(value = "id", type = IdType.ASSIGN_ID)

    private Long id;

    /**
     * 房间名称
     */
    @ApiModelProperty(value = "房间名称")
    private String roomName;
    /**
     * 房间介绍
     */
    @ApiModelProperty(value = "房间介绍")
    private String roomDesc;
    /**
     * 房间状态
     */
    @ApiModelProperty(value = "房间状态")
    private Integer roomStatus;

}