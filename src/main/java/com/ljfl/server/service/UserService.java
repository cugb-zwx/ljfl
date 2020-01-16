package com.ljfl.server.service;

import com.ljfl.server.dto.UserDTO;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 21:24
 */
public interface UserService {
    String login(UserDTO dto);

    String addUser(UserDTO dto);

    void updateUser(UserDTO dto);

    UserDTO getUser(UserDTO dto);

    boolean isHasUser(UserDTO dto);
}
