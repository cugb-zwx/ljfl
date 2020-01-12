package com.ljfl.server.converters;

import com.ljfl.server.common.utils.DateUtil;
import com.ljfl.server.domain.po.GarbageOnePOWithBLOBs;
import com.ljfl.server.dto.GarbageOneDTO;
import com.ljfl.server.vo.req.GarbageOneReq;
import com.ljfl.server.vo.res.GarbageOneRes;

/**
 * Created by sec on 2020-1-6.
 */
public class GarbageOneConverter {
    public static GarbageOneDTO reqToDTO(GarbageOneReq req) {
        if (req == null) {
            return null;
        }
        GarbageOneDTO garbageOneDTO = new GarbageOneDTO();
        garbageOneDTO.setCityCode(req.getCityCode());
        return garbageOneDTO;
    }

    public static GarbageOnePOWithBLOBs dtoToPO(GarbageOneDTO dto) {
        if (dto == null) {
            return null;
        }
        GarbageOnePOWithBLOBs garbageOnePO = new GarbageOnePOWithBLOBs();
        garbageOnePO.setId(dto.getId());
        garbageOnePO.setCityCode(dto.getCityCode());
        garbageOnePO.setName(dto.getName());
        garbageOnePO.setRemark(dto.getReMark());
        garbageOnePO.setCrateTime(DateUtil.longToDate(dto.getCreateTime()));
        garbageOnePO.setUpdateTime(DateUtil.longToDate(dto.getUpdateTime()));
        garbageOnePO.setNote(dto.getNote());
        garbageOnePO.setIsDelete(dto.getIsDelete());
        return garbageOnePO;
    }

    public static GarbageOneDTO poToDTO(GarbageOnePOWithBLOBs po) {
        if (po == null) {
            return null;
        }
        GarbageOneDTO garbageOneDTO = new GarbageOneDTO();
        garbageOneDTO.setId(po.getId());
        garbageOneDTO.setCityCode(po.getCityCode());
        garbageOneDTO.setName(po.getName());
        garbageOneDTO.setReMark(po.getRemark());
        garbageOneDTO.setCreateTime(DateUtil.dateToLong(po.getCrateTime()));
        garbageOneDTO.setUpdateTime(DateUtil.dateToLong(po.getUpdateTime()));
        garbageOneDTO.setIsDelete(po.getIsDelete());
        garbageOneDTO.setNote(po.getNote());
        return garbageOneDTO;
    }

    public static GarbageOneRes dtoToRes(GarbageOneDTO dto) {
        if (dto == null) {
            return null;
        }
        GarbageOneRes garbageOneRes = new GarbageOneRes();
        garbageOneRes.setId(dto.getId());
        garbageOneRes.setCityCode(dto.getCityCode());
        garbageOneRes.setName(dto.getName());
        garbageOneRes.setReMark(dto.getReMark());
        garbageOneRes.setCreateTime(DateUtil.longToStr(dto.getCreateTime()));
        garbageOneRes.setUpdateTime(DateUtil.longToStr(dto.getUpdateTime()));
        garbageOneRes.setNote(dto.getNote());
        return garbageOneRes;
    }

}
