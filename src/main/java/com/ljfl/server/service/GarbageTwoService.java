package com.ljfl.server.service;

import com.ljfl.server.dto.GarbageTwoDTO;

import java.util.List;

/**
 * Created by sec on 2020-1-6.
 */
public interface GarbageTwoService {
    List<GarbageTwoDTO> list(GarbageTwoDTO dto);
}
