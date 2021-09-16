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
 * 新闻资讯表(News)新闻资讯表
 *
 * @author wq
 * @since 2021-09-16 14:47:30
 */
@ApiModel(value = "新闻资讯表(News)实体类", description = "新闻资讯表(News)实体类")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_news")
public class NewsEntity extends Model<NewsEntity> implements Serializable {


    @TableId(value = "id", type = IdType.ASSIGN_ID)

    private Long id;

    /**
     * 新闻图片
     */
    @ApiModelProperty(value = "新闻图片")
    private String images;
    /**
     * 新闻标题
     */
    @ApiModelProperty(value = "新闻标题")
    private String title;
    /**
     * 正文
     */
    @ApiModelProperty(value = "正文")
    private String content;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 发布人
     */
    @ApiModelProperty(value = "发布人")
    private Long userId;
    /**
     * 新闻排序
     */
    @ApiModelProperty(value = "新闻排序")
    private Long newsOrder;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

}