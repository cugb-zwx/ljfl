package com.ljfl.server.biz;

import com.ljfl.server.dto.GarbageOneDTO;
import com.ljfl.server.service.GarbageOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sec on 2020-1-6.
 */
@Service
@Transactional
public class GarbageOneBiz {
    @Autowired
    private GarbageOneService garbageOneService;

    public List<GarbageOneDTO> list(GarbageOneDTO dto) {
       return garbageOneService.list(dto);
    }
}
