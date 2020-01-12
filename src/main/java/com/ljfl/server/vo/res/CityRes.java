package com.ljfl.server.vo.res;
import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by sec on 2020-1-2.
 */
public class CityRes extends BaseVO {
    private static final long serialVersionUID = 3939302248038510574L;

    @ApiModelProperty("城市ID")
    private String id;
    @ApiModelProperty("城市名称")
    private String name;
    @ApiModelProperty("城市拼音")
    private String py;
    @ApiModelProperty("城市编码")
    private String code;
    @ApiModelProperty("省份编码")
    private String provinceCode;
    @ApiModelProperty("启用状态")
    private Boolean state;
    @ApiModelProperty("城市状态")
    private String isDelete;
    @ApiModelProperty("城市备注")
    private String note;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
