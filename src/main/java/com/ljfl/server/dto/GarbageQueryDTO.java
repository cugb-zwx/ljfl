package com.ljfl.server.dto;

/**
 * Created by sec on 2020-1-7.
 */
public class GarbageQueryDTO {
    private String id;

    private String name;

    private String imgBase64;

    private String cityCode;

    private String garbageOneId;

    private String reMark;

    private String isDelete;

    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getGarbageOneId() {
        return garbageOneId;
    }

    public void setGarbageOneId(String garbageOneId) {
        this.garbageOneId = garbageOneId;
    }

    public String getReMark() {
        return reMark;
    }

    public void setReMark(String reMark) {
        this.reMark = reMark;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
