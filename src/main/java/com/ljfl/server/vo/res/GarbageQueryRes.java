package com.ljfl.server.vo.res;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sec on 2020-1-7.
 */
public class GarbageQueryRes extends BaseVO{

    private static final long serialVersionUID = 3939302248038510574L;
    @ApiModelProperty("垃圾id")
    private String id;
    @ApiModelProperty("垃圾名称")
    private String name;
    @ApiModelProperty("城市编码")
    private String cityCode;
    @ApiModelProperty("垃圾类别id")
    private String garbageOneId;
    @ApiModelProperty("垃圾描述")
    private String reMark;
    @ApiModelProperty("备注")
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
