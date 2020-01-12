package com.ljfl.server.service;

import com.ljfl.server.dto.UserSignDTO;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 23:15
 */
public interface UserSignService {

    long countSignUser(UserSignDTO dto);

    void sign(UserSignDTO dto);

    List<UserSignDTO> listUserSign(UserSignDTO dto);
}
