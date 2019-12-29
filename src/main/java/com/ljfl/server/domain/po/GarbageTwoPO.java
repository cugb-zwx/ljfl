package com.ljfl.server.domain.po;

import java.io.Serializable;
import java.util.Date;

public class GarbageTwoPO implements Serializable {
    private String id;

    private String cityCode;

    private String garbageOneId;

    private String name;

    private Date crateTime;

    private Date updateTime;

    private String status;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getGarbageOneId() {
        return garbageOneId;
    }

    public void setGarbageOneId(String garbageOneId) {
        this.garbageOneId = garbageOneId == null ? null : garbageOneId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}