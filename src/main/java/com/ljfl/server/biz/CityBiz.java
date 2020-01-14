package com.ljfl.server.biz;

import com.ljfl.server.domain.po.CityPO;
import com.ljfl.server.dto.CityDTO;
import com.ljfl.server.dto.GovFileDTO;
import com.ljfl.server.service.CityService;
import com.ljfl.server.vo.res.CityRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by sec on 2020-1-2.
 */
@Service
@Transactional
public class CityBiz {
    @Autowired
    private CityService cityService;

    public List<GovFileDTO> listGov(GovFileDTO dto) {return cityService.listGov(dto);}
    public List<CityDTO> list() {
        return cityService.list();
    }
    public Map<String,List<Object>>op(List<CityRes> list){
        return  cityService.op(list);
    }

}
