package com.ljfl.server.vo.req;

import com.ljfl.server.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 20:50
 */
public class CreateCustomerOrderReq extends BaseVO {
    private static final long serialVersionUID = 3939302248038510574L;
    @ApiModelProperty("客户手机号")
    private String phone;
    @ApiModelProperty("手机验证码")
    private String code;
    @ApiModelProperty("下单城市")
    private String city;
    @ApiModelProperty("下单服务集合")
    private String services;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }
}
