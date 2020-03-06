package com.ljfl.server.vo.res;

import com.ljfl.server.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sec on 2020-1-7.
 */
public class GovFileRes extends BaseVO{
    @ApiModelProperty("城市ID")
    private Integer id;
    @ApiModelProperty("城市名称")
    private String name;
    @ApiModelProperty("官方意见")
    private String reg;
    @ApiModelProperty("处罚办法")
    private String pub;
    @ApiModelProperty("省份编码")
    private String provinceCode;
    @ApiModelProperty("启用标志")
    private Boolean state;
    @ApiModelProperty("城市备注")
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
