package com.ljfl.server.vo.req;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sec on 2020-1-7.
 */
public class GovFileReq extends BaseVO {
    private static final long serialVersionUID = 3939302248038510574L;
    @ApiModelProperty("城市编码")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
