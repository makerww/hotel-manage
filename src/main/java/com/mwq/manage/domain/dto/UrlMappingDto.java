package com.mwq.manage.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * ..
 * </p>
 *
 * @author wq
 * @since 2021-09-16 15:59
 **/
@Data
@ApiModel("地址地图")
public class UrlMappingDto implements Serializable {
    @ApiModelProperty("父节点")
    private String parent;
    @ApiModelProperty("地址")
    private String path;
    @ApiModelProperty("请求方法")
    private String method;
    @ApiModelProperty("描述")
    private String desc;
}
