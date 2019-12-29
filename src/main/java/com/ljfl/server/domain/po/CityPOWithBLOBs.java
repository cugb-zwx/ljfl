package com.ljfl.server.domain.po;

import java.io.Serializable;

public class CityPOWithBLOBs extends CityPO implements Serializable {
    private String reg;

    private String puh;

    private static final long serialVersionUID = 1L;

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg == null ? null : reg.trim();
    }

    public String getPuh() {
        return puh;
    }

    public void setPuh(String puh) {
        this.puh = puh == null ? null : puh.trim();
    }
}