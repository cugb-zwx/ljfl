package com.ljfl.server.vo.res;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/30 0:34
 */
public class UserSignRes extends BaseVO {
    private static final long serialVersionUID = -4696169128812107985L;

    @ApiModelProperty("唯一标识ID")
    private String id;
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("签到类型 0未签 1已签 2补签")
    private String signType;
    @ApiModelProperty("签到时间")
    private String createTime;
    @ApiModelProperty("更新时间")
    private String updateTime;
    @ApiModelProperty("备注")
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
