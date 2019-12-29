package com.ljfl.server.biz;

import com.ljfl.server.dto.UserDTO;
import com.ljfl.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 21:22
 */
@Service
@Transactional
public class UserBiz {

    @Autowired
    private UserService userService;

    public void addUser(UserDTO dto) {
        userService.addUser(dto);
    }

    public UserDTO getUser(UserDTO dto) {
        return userService.getUser(dto);
    }

    public boolean isHasUser(UserDTO dto) {
        return userService.isHasUser(dto);
    }
}
