package com.ljfl.server.vo.req;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sec on 2020-1-6.
 */
public class GarbageOneReq extends BaseVO {
    private static final long serialVersionUID = -5916167473706523249L;

    @ApiModelProperty("城市编码")
    private String cityCode;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

}
