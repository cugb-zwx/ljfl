package com.ljfl.server.vo.req;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 20:50
 */
public class IdReq extends BaseVO {
    private static final long serialVersionUID = -5916167473706523249L;
    @ApiModelProperty("唯一标识")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
