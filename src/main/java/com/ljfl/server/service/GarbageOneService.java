package com.ljfl.server.service;

import com.ljfl.server.dto.GarbageOneDTO;

import java.util.List;

/**
 * Created by sec on 2020-1-6.
 */
public interface GarbageOneService {
    List<GarbageOneDTO> list(GarbageOneDTO dto);
}
