package com.ljfl.server.converters;

import com.ljfl.server.common.utils.DateUtil;
import com.ljfl.server.domain.po.GarbageTwoPO;
import com.ljfl.server.domain.po.GarbageTwoPOWithBLOBs;
import com.ljfl.server.dto.GarbageQueryDTO;
import com.ljfl.server.vo.req.GarbageQueryReq;
import com.ljfl.server.vo.res.GarbageQueryRes;

/**
 * Created by sec on 2020-1-7.
 */
public class GarbageQueryConverter {
    public static GarbageQueryDTO reqToDTO(GarbageQueryReq req) {
        if (req == null) {
            return null;
        }
        GarbageQueryDTO garbageQueryDTO = new GarbageQueryDTO();
        garbageQueryDTO.setCityCode(req.getCityCode());
        garbageQueryDTO.setName(req.getName());
        garbageQueryDTO.setImgBase64(req.getImgBase64());
        return garbageQueryDTO;
    }

    public static GarbageTwoPOWithBLOBs dtoToPO(GarbageQueryDTO dto) {
        if (dto == null) {
            return null;
        }
        GarbageTwoPOWithBLOBs garbageTwoPO = new GarbageTwoPOWithBLOBs();
        garbageTwoPO.setId(dto.getId());
        garbageTwoPO.setCityCode(dto.getCityCode());
        garbageTwoPO.setGarbageOneId(dto.getGarbageOneId());
        garbageTwoPO.setName(dto.getName());
        garbageTwoPO.setRemark(dto.getReMark());
        garbageTwoPO.setNote(dto.getNote());
        garbageTwoPO.setIsDelete(dto.getIsDelete());
//        garbageTwoPO.setimgBase64(dto.getImgBase64());
        return  garbageTwoPO;
    }

    public static GarbageQueryDTO poToDTO(GarbageTwoPOWithBLOBs po) {
        if (po == null) {
            return null;
        }
        GarbageQueryDTO garbageQueryDTO = new GarbageQueryDTO();
        garbageQueryDTO.setId(po.getId());
        garbageQueryDTO.setCityCode(po.getCityCode());
        garbageQueryDTO.setGarbageOneId(po.getGarbageOneId());
        garbageQueryDTO.setName(po.getName());
        garbageQueryDTO.setReMark(po.getRemark());
        garbageQueryDTO.setIsDelete(po.getIsDelete());
        garbageQueryDTO.setNote(po.getNote());
        return garbageQueryDTO;
    }


    public static GarbageQueryRes dtoToRes(GarbageQueryDTO dto) {
        if (dto == null) {
            return null;
        }
        GarbageQueryRes garbageQueryRes = new GarbageQueryRes();
        garbageQueryRes.setId(dto.getId());
        garbageQueryRes.setCityCode(dto.getCityCode());
        garbageQueryRes.setName(dto.getName());
        garbageQueryRes.setGarbageOneId(dto.getGarbageOneId());
        garbageQueryRes.setReMark(dto.getReMark());
        garbageQueryRes.setNote(dto.getNote());
        return garbageQueryRes;
    }
}
