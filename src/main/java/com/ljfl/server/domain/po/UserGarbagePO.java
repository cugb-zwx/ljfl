package com.ljfl.server.domain.po;

import java.io.Serializable;
import java.util.Date;

public class UserGarbagePO implements Serializable {
    private String id;

    private String userId;

    private String garbageTwoId;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getGarbageTwoId() {
        return garbageTwoId;
    }

    public void setGarbageTwoId(String garbageTwoId) {
        this.garbageTwoId = garbageTwoId == null ? null : garbageTwoId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}