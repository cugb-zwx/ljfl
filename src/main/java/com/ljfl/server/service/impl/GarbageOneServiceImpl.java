package com.ljfl.server.service.impl;

import com.ljfl.server.converters.CityConverter;
import com.ljfl.server.converters.GarbageOneConverter;
import com.ljfl.server.dao.mapper.GarbageOnePOMapper;
import com.ljfl.server.domain.po.GarbageOnePO;
import com.ljfl.server.domain.po.GarbageOnePOExample;
import com.ljfl.server.domain.po.GarbageOnePOWithBLOBs;
import com.ljfl.server.dto.GarbageOneDTO;
import com.ljfl.server.service.GarbageOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sec on 2020-1-6.
 */
@Service
public class GarbageOneServiceImpl implements GarbageOneService {
    @Autowired
    private GarbageOnePOMapper garbageOnePOMapper;

    @Override
    public List<GarbageOneDTO> list(GarbageOneDTO dto) {
        GarbageOnePOExample poExample =new GarbageOnePOExample();
        GarbageOnePOExample.Criteria criteria = poExample.createCriteria();
        criteria.andCityCodeEqualTo(dto.getCityCode());
        poExample.setOrderByClause("id asc");
        List<GarbageOnePOWithBLOBs> list =garbageOnePOMapper.selectByExampleWithBLOBs(poExample);
        return list.stream().map(GarbageOneConverter::poToDTO).collect(Collectors.toList());
    }

}
