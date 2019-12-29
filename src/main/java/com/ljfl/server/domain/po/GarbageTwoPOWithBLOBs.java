package com.ljfl.server.domain.po;

import java.io.Serializable;

public class GarbageTwoPOWithBLOBs extends GarbageTwoPO implements Serializable {
    private String remark;

    private String note;

    private static final long serialVersionUID = 1L;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}