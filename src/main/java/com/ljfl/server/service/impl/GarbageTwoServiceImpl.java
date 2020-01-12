package com.ljfl.server.service.impl;

import com.ljfl.server.converters.GarbageTwoConverter;
import com.ljfl.server.dao.mapper.GarbageTwoPOMapper;
import com.ljfl.server.domain.po.GarbageTwoPOExample;
import com.ljfl.server.domain.po.GarbageTwoPOWithBLOBs;
import com.ljfl.server.dto.GarbageTwoDTO;
import com.ljfl.server.service.GarbageTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sec on 2020-1-6.
 */
@Service
public class GarbageTwoServiceImpl implements GarbageTwoService {
    @Autowired
    private GarbageTwoPOMapper garbageTwoPOMapper;

    @Override
    public List<GarbageTwoDTO> list(GarbageTwoDTO dto) {
        GarbageTwoPOExample poExample =new GarbageTwoPOExample();
        GarbageTwoPOExample.Criteria criteria = poExample.createCriteria();
        criteria.andCityCodeEqualTo(dto.getCityCode());
        criteria.andGarbageOneIdEqualTo(dto.getGarbageOneId());
        poExample.setOrderByClause("garbage_one_id asc");
        List<GarbageTwoPOWithBLOBs> list =garbageTwoPOMapper.selectByExampleWithBLOBs(poExample);
        return list.stream().map(GarbageTwoConverter::poToDTO).collect(Collectors.toList());
    }
}
