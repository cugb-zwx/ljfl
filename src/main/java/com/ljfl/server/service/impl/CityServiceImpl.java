package com.ljfl.server.service.impl;

import com.ljfl.server.converters.CityConverter;
import com.ljfl.server.converters.GovFileConverter;
import com.ljfl.server.dao.mapper.CityPOMapper;
import com.ljfl.server.domain.po.CityPO;
import com.ljfl.server.domain.po.CityPOExample;
import com.ljfl.server.domain.po.CityPOWithBLOBs;
import com.ljfl.server.dto.CityDTO;
import com.ljfl.server.dto.GovFileDTO;
import com.ljfl.server.service.CityService;
import com.ljfl.server.vo.res.CityRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sec on 2020-1-2.
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityPOMapper cityPOMapper;

    @Override
    public List<CityDTO> list() {

        CityPOExample poExample =new CityPOExample();
        CityPOExample.Criteria criteria = poExample.createCriteria();
        criteria.andStateEqualTo(true);
        criteria.andProvinceCodeIsNotNull();
        criteria.andPyIsNotNull();
        poExample.setOrderByClause("province_code asc,py asc");
        List<CityPO> list =cityPOMapper.selectByExample(poExample);
        return list.stream().map(CityConverter::poToDTO).collect(Collectors.toList());
    }
    @Override
    public List<GovFileDTO> listGov(GovFileDTO dto){
        CityPOExample poExample =new CityPOExample();
        CityPOExample.Criteria criteria = poExample.createCriteria();
        criteria.andCodeEqualTo(dto.getCode());
        criteria.andStateEqualTo(true);
        List<CityPOWithBLOBs> list =cityPOMapper.selectByExampleWithBLOBs(poExample);
        return list.stream().map(GovFileConverter::poToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Map<String,List<Object>>>op(List<CityRes> list) {
        //获取首写字母分组排序城市列表
        List< Map<String, List<Object>>>mapList= new ArrayList<>();
        Map<String, List<Object>> mapZm = new LinkedHashMap<>();
        //获取热门城市列表
        Map<String, List<Object>> mapRm = new LinkedHashMap<>();
        mapList.add(mapRm);
        mapList.add(mapZm);
        String[] letter = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M",
                "N", "P", "Q", "R", "S", "T", "W", "X", "Y", "Z"};
        //创建按首字母大写为key的map集合,Map("A",list1),Map("B",list2)
        for (int i = 0; i < letter.length; i++) {
            mapZm.put(letter[i], new ArrayList<>());
        }
        for (Iterator iterators = list.iterator(); iterators.hasNext(); ) {
            CityRes c = (CityRes) iterators.next();//获取当前遍历的元素，
            String py = c.getPy().substring(0, 1).toUpperCase();
            //note 为热门城市标记
            String ps= c.getIsDelete();
            if (mapZm.containsKey(py)) {
                mapZm.get(py).add(c);
            }
            if (ps.equals("1"))//“热门”
            {
                List <Object> rm=mapRm.get("热门");
                if(rm==null){
                    rm=new ArrayList<>();
                    mapRm.put("热门",rm);
                }
                rm.add(c);
            }
        }
        return mapList;
    }
}




