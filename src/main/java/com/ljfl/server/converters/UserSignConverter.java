package com.ljfl.server.converters;

import com.ljfl.server.common.utils.DateUtil;
import com.ljfl.server.domain.po.UserSignPO;
import com.ljfl.server.dto.UserSignDTO;
import com.ljfl.server.vo.req.IdReq;
import com.ljfl.server.vo.res.UserSignRes;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 23:12
 */
public class UserSignConverter {
    public static UserSignDTO reqToDTO(IdReq req) {
        if (req == null) {
            return null;
        }
        UserSignDTO userSignDTO = new UserSignDTO();
        userSignDTO.setUserId(req.getId());
        return userSignDTO;
    }

    public static UserSignPO dtoToPO(UserSignDTO dto) {
        if (dto == null) {
            return null;
        }
        UserSignPO userSignPO = new UserSignPO();
        userSignPO.setId(dto.getId());
        userSignPO.setUserId(dto.getUserId());
        userSignPO.setSignType(dto.getSignType());
        userSignPO.setCreateTime(DateUtil.longToDate(dto.getCreateTime()));
        userSignPO.setUpdateTime(DateUtil.longToDate(dto.getUpdateTime()));
        userSignPO.setNote(dto.getNote());
        return userSignPO;
    }

    public static UserSignDTO poToDTO(UserSignPO po) {
        if (po == null) {
            return null;
        }
        UserSignDTO userSignDTO = new UserSignDTO();
        userSignDTO.setId(po.getId());
        userSignDTO.setUserId(po.getUserId());
        userSignDTO.setSignType(po.getSignType());
        userSignDTO.setCreateTime(DateUtil.dateToLong(po.getCreateTime()));
        userSignDTO.setUpdateTime(DateUtil.dateToLong(po.getUpdateTime()));
        userSignDTO.setIsDelete(po.getIsDelete());
        userSignDTO.setNote(po.getNote());
        return userSignDTO;
    }

    public static UserSignRes dtoToRes(UserSignDTO dto) {
        if (dto == null) {
            return null;
        }
        UserSignRes userSignRes = new UserSignRes();
        userSignRes.setId(dto.getId());
        userSignRes.setUserId(dto.getUserId());
        userSignRes.setSignType(dto.getSignType());
        userSignRes.setCreateTime(DateUtil.longToStr(dto.getCreateTime()));
        userSignRes.setUpdateTime(DateUtil.longToStr(dto.getUpdateTime()));
        userSignRes.setNote(dto.getNote());
        return userSignRes;
    }
}
