package com.ljfl.server.biz;

import com.ljfl.server.common.utils.DateUtil;
import com.ljfl.server.dto.GarbageQueryDTO;
import com.ljfl.server.dto.GarbageTwoDTO;
import com.ljfl.server.service.GarbageService;
import com.ljfl.server.vo.req.AddGarbageReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by sec on 2020-1-7.
 */
@Service
@Transactional
public class GarbageBiz {
    @Autowired
    private GarbageService garbageService;

    public List<GarbageQueryDTO> txtsearch(GarbageQueryDTO dto) {
        return garbageService.txtsearch(dto);
    }

    public  List<GarbageQueryDTO> picsearch(GarbageQueryDTO dto) {
        return garbageService.picsearch(dto);
    }

    public  List<GarbageQueryDTO> search(GarbageQueryDTO dto) {
        return garbageService.search(dto);
    }

    public void addGarbage(GarbageTwoDTO dto) {
        Date now = new Date();
        dto.setCreateTime(DateUtil.dateToLong(now));
        dto.setUpdateTime(DateUtil.dateToLong(now));
        garbageService.addGarbage(dto);
    }
    public void updateGarbage(GarbageTwoDTO dto) {
        Date now = new Date();
        dto.setUpdateTime(DateUtil.dateToLong(now));
        garbageService.updateGarbage(dto);}
}
