package com.ljfl.server.converters;

import com.ljfl.server.domain.po.CityPO;
import com.ljfl.server.domain.po.CityPOWithBLOBs;
import com.ljfl.server.dto.GovFileDTO;
import com.ljfl.server.vo.req.GovFileReq;
import com.ljfl.server.vo.res.GovFileRes;

/**
 * Created by sec on 2020-1-7.
 */
public class GovFileConverter {
    public static GovFileDTO reqToDTO(GovFileReq req) {
        if (req == null) {
            return null;
        }
        GovFileDTO govFileDTO = new GovFileDTO();
        govFileDTO.setCode(req.getCode());
        return govFileDTO;
    }

    public static CityPO dtoToPO(GovFileDTO dto) {
        if (dto == null) {
            return null;
        }
        CityPOWithBLOBs govFilePO = new CityPOWithBLOBs();
        govFilePO.setId(dto.getId());
        govFilePO.setCode(dto.getCode());
        govFilePO.setName(dto.getName());
        govFilePO.setReg(dto.getReg());
        govFilePO.setNote(dto.getNote());
        govFilePO.setState(dto.getState());
        govFilePO.setPuh(dto.getPub());
        govFilePO.setProvinceCode(dto.getProvinceCode());
        return govFilePO;
    }

    public static GovFileDTO poToDTO(CityPOWithBLOBs po) {
        if (po == null) {
            return null;
        }
        GovFileDTO govFileDTO = new GovFileDTO();
        govFileDTO.setId(po.getId());
        govFileDTO.setCode(po.getCode());
        govFileDTO.setName(po.getName());
        govFileDTO.setReg(po.getReg());
        govFileDTO.setPub(po.getPuh());
        govFileDTO.setProvinceCode(po.getProvinceCode());
        govFileDTO.setState(po.getState());
        govFileDTO.setNote(po.getNote());
        return govFileDTO;
    }

    public static GovFileRes dtoToRes(GovFileDTO dto) {
        if (dto == null) {
            return null;
        }
        GovFileRes govFileRes = new GovFileRes();
        govFileRes.setId(dto.getId());
        govFileRes.setName(dto.getName());
        govFileRes.setReg(dto.getReg());
        govFileRes.setProvinceCode(dto.getProvinceCode());
        govFileRes.setPub(dto.getPub());
        govFileRes.setNote(dto.getNote());
        govFileRes.setState(dto.getState());
        return govFileRes;
    }
}
