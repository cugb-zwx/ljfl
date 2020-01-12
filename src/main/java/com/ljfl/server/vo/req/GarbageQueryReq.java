package com.ljfl.server.vo.req;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sec on 2020-1-7.
 */
public class GarbageQueryReq extends BaseVO{
    private static final long serialVersionUID = 3939302248038510574L;

    @ApiModelProperty("垃圾名称")
    private String name;
    @ApiModelProperty("垃圾图片")
    private String imgBase64;
    @ApiModelProperty("城市编码")
    private String cityCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
