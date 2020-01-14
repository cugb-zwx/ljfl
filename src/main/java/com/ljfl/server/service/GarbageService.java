package com.ljfl.server.service;

import com.ljfl.server.dto.GarbageQueryDTO;
import com.ljfl.server.dto.GarbageTwoDTO;

import java.util.List;

/**
 * Created by sec on 2020-1-7.
 */
public interface GarbageService {
    List<GarbageQueryDTO> txtsearch(GarbageQueryDTO dto);
    List<GarbageQueryDTO> picsearch(GarbageQueryDTO dto);
    void addGarbage(GarbageTwoDTO dto);
    void updateGarbage(GarbageTwoDTO dto);
}
