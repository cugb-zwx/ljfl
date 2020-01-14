package com.ljfl.server.biz;

import com.ljfl.server.common.exceptions.CustomException;
import com.ljfl.server.dto.UserDTO;
import com.ljfl.server.remote.weixin.WeixinLoginUtil;
import com.ljfl.server.remote.weixin.res.WeiXinLoginRes;
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
        WeiXinLoginRes res = WeixinLoginUtil.login(dto.getCode());
        if (!res.isSuccess()) {
            throw new CustomException(res.getErrmsg());
        }
        dto.setOpenid(res.getOpenid());
        userService.addUser(dto);
    }

    public UserDTO getUser(UserDTO dto) {
        return userService.getUser(dto);
    }

    public boolean isHasUser(UserDTO dto) {
        return userService.isHasUser(dto);
    }
}
