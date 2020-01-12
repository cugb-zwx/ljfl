package com.ljfl.server.service;

import com.ljfl.server.dto.CityDTO;
import com.ljfl.server.dto.GovFileDTO;
import com.ljfl.server.vo.res.CityRes;

import java.util.List;
import java.util.Map;

/**
 * Created by sec on 2020-1-2.
 */
public interface CityService {
    List<CityDTO> list();
    List<GovFileDTO> listGov(GovFileDTO dto);
    List<Map<String,List<Object>>>op(List<CityRes> list);
}
