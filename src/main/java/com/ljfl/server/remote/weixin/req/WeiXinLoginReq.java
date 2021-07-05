package com.ljfl.server.remote.weixin.req;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2020/1/14 23:49
 */
public class WeiXinLoginReq extends BaseVO {

    private static final long serialVersionUID = 5566344379189693974L;

    @ApiModelProperty("appid")
    private String appid;
    @ApiModelProperty("secret")
    private String secret;
    @ApiModelProperty("js_code")
    private String js_code;
    @ApiModelProperty("grant_type")
    private String grant_type;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getJs_code() {
        return js_code;
    }

    public void setJs_code(String js_code) {
        this.js_code = js_code;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
