package com.ljfl.server.vo.res;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sec on 2020-1-6.
 */
public class GarbageOneRes extends BaseVO {
    private static final long serialVersionUID = 2313116992289233425L;

    @ApiModelProperty("垃圾类别id")
    private String id;
    @ApiModelProperty("城市编码")
    private String cityCode;
    @ApiModelProperty("垃圾类别")
    private String name;
    @ApiModelProperty("垃圾类别描述")
    private String reMark;
    @ApiModelProperty("状态")
    private String isDelete;
    @ApiModelProperty("创建时间")
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

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
