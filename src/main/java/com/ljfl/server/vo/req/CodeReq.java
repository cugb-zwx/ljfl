package com.ljfl.server.vo.req;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 20:50
 */
public class CodeReq extends BaseVO {
    private static final long serialVersionUID = -5916167473706523249L;
    @ApiModelProperty("微信code")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
