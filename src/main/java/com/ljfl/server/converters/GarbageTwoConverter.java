package com.ljfl.server.converters;

import com.ljfl.server.common.utils.DateUtil;
import com.ljfl.server.domain.po.GarbageTwoPO;
import com.ljfl.server.domain.po.GarbageTwoPOWithBLOBs;
import com.ljfl.server.dto.GarbageTwoDTO;
import com.ljfl.server.vo.req.GarbageTwoReq;
import com.ljfl.server.vo.res.GarbageTwoRes;
import com.ljfl.server.vo.req.AddGarbageReq;

/**
 * Created by sec on 2020-1-6.
 */
public class GarbageTwoConverter {
    public static GarbageTwoDTO reqToDTO(GarbageTwoReq req) {
        if (req == null) {
            return null;
        }
        GarbageTwoDTO garbageTwoDTO = new GarbageTwoDTO();
        garbageTwoDTO.setCityCode(req.getCityCode());
        garbageTwoDTO.setGarbageOneId(req.getGarbageOneId());
        return garbageTwoDTO;
    }


    public static GarbageTwoDTO reqToDTO(AddGarbageReq req) {
        if (req == null) {
            return null;
        }
        GarbageTwoDTO garbageTwoDTO = new GarbageTwoDTO();
        garbageTwoDTO.setName(req.getName());
        garbageTwoDTO.setCityCode(req.getCityCode());
        garbageTwoDTO.setGarbageOneId(req.getGarbageOneId());
        garbageTwoDTO.setReMark(req.getReMark());
        return garbageTwoDTO;
    }

    public static GarbageTwoPOWithBLOBs dtoToPO(GarbageTwoDTO dto) {
        if (dto == null) {
            return null;
        }
        GarbageTwoPOWithBLOBs garbageTwoPO = new GarbageTwoPOWithBLOBs();
        garbageTwoPO.setId(dto.getId());
        garbageTwoPO.setCityCode(dto.getCityCode());
        garbageTwoPO.setGarbageOneId(dto.getGarbageOneId());
        garbageTwoPO.setName(dto.getName());
        garbageTwoPO.setRemark(dto.getReMark());
        garbageTwoPO.setCrateTime(DateUtil.longToDate(dto.getCreateTime()));
        garbageTwoPO.setUpdateTime(DateUtil.longToDate(dto.getUpdateTime()));
        garbageTwoPO.setNote(dto.getNote());
        garbageTwoPO.setIsDelete(dto.getIsDelete());
        return garbageTwoPO;
    }

    public static GarbageTwoDTO poToDTO(GarbageTwoPOWithBLOBs po) {
        if (po == null) {
            return null;
        }
        GarbageTwoDTO garbageTwoDTO = new GarbageTwoDTO();
        garbageTwoDTO.setId(po.getId());
        garbageTwoDTO.setCityCode(po.getCityCode());
        garbageTwoDTO.setGarbageOneId(po.getGarbageOneId());
        garbageTwoDTO.setName(po.getName());
        garbageTwoDTO.setReMark(po.getRemark());
        garbageTwoDTO.setCreateTime(DateUtil.dateToLong(po.getCrateTime()));
        garbageTwoDTO.setUpdateTime(DateUtil.dateToLong(po.getUpdateTime()));
        garbageTwoDTO.setIsDelete(po.getIsDelete());
        garbageTwoDTO.setNote(po.getNote());
        return garbageTwoDTO;
    }

    public static GarbageTwoRes dtoToRes(GarbageTwoDTO dto) {
        if (dto == null) {
            return null;
        }
        GarbageTwoRes garbageTwoRes = new GarbageTwoRes();
        garbageTwoRes.setId(dto.getId());
        garbageTwoRes.setCityCode(dto.getCityCode());
        garbageTwoRes.setName(dto.getName());
        garbageTwoRes.setGarbageOneId(dto.getGarbageOneId());
        garbageTwoRes.setCreateTime(DateUtil.longToStr(dto.getCreateTime()));
        garbageTwoRes.setUpdateTime(DateUtil.longToStr(dto.getUpdateTime()));
        garbageTwoRes.setNote(dto.getNote());
        return garbageTwoRes;
    }
}
