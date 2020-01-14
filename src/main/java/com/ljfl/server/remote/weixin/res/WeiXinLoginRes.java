package com.ljfl.server.remote.weixin.res;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2020/1/14 23:50
 */
public class WeiXinLoginRes extends BaseVO {
    private static final long serialVersionUID = -3254209668400859516L;
    @ApiModelProperty("openid")
    private String openid;
    @ApiModelProperty("session_key")
    private String session_key;
    @ApiModelProperty("unionid")
    private String unionid;
    @ApiModelProperty("errcode")
    private String errcode;
    @ApiModelProperty("errmsg")
    private String errmsg;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public boolean isSuccess() {
        return Objects.deepEquals(getErrcode(), "0");
    }
}
