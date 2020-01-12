package com.ljfl.server.biz;

import com.ljfl.server.dto.GarbageTwoDTO;
import com.ljfl.server.service.GarbageTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sec on 2020-1-6.
 */
@Service
@Transactional
public class GarbageTwoBiz {
    @Autowired
    private GarbageTwoService garbageTwoService;

    public List<GarbageTwoDTO> list(GarbageTwoDTO dto) {
        return garbageTwoService.list(dto);
    }
}
