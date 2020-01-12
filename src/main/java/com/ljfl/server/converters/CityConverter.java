package com.ljfl.server.converters;

import com.ljfl.server.common.utils.DateUtil;
import com.ljfl.server.domain.po.CityPO;
import com.ljfl.server.dto.CityDTO;
import com.ljfl.server.vo.res.CityRes;

/**
 * Created by sec on 2020-1-6.
 */
public class CityConverter {


    public static CityDTO poToDTO(CityPO po) {
        if (po == null) {
            return null;
        }
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(po.getId());
        cityDTO.setName(po.getName());
        cityDTO.setCode(po.getCode());
        cityDTO.setPy(po.getPy());
        cityDTO.setProvinceCode(po.getProvinceCode());
        cityDTO.setState(po.getState());
        cityDTO.setIsDelete(po.getIsDelete());
        cityDTO.setCreateTime(DateUtil.dateToLong(po.getCreateTime()));
        cityDTO.setUpdateTime(DateUtil.dateToLong(po.getUpdateTime()));
        cityDTO.setNote(po.getNote());
        return cityDTO;
    }


    public static CityRes dtoToRes(CityDTO dto) {
        if (dto == null) {
            return null;
        }
        CityRes cityRes = new  CityRes();
        cityRes.setId(dto.getId());
        cityRes.setName(dto.getName());
        cityRes.setCode(dto.getCode());
        cityRes.setPy(dto.getPy());
        cityRes.setProvinceCode(dto.getProvinceCode());
        cityRes.setState(dto.getState());
        cityRes.setIsDelete(dto.getIsDelete());
        cityRes.setNote(dto.getNote());
        return  cityRes;
    }
}
