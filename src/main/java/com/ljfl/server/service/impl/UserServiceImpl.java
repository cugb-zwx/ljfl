package com.ljfl.server.service.impl;

import com.ljfl.server.converters.UserConverter;
import com.ljfl.server.dao.mapper.UserPOMapper;
import com.ljfl.server.dao.mapper.manual.UserPOManualMapper;
import com.ljfl.server.domain.po.UserPO;
import com.ljfl.server.dto.UserDTO;
import com.ljfl.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 21:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPOMapper userPOMapper;
    @Autowired
    private UserPOManualMapper userPOManualMapper;

    @Override
    public void addUser(UserDTO dto) {
        UserPO po = UserConverter.dtoToPO(dto);
        if (po.getId() == null) po.setId(UUID.randomUUID().toString().substring(0, 20));
        userPOMapper.insertSelective(po);
    }

    @Override
    public UserDTO getUser(UserDTO dto) {
        String openid = dto.getOpenid();
        UserPO po = userPOManualMapper.getUser(openid);
        return UserConverter.poToDTO(po);
    }

    @Override
    public boolean isHasUser(UserDTO dto) {
        String openid = dto.getOpenid();
        long count = userPOManualMapper.countUser(openid);
        if (count > 0) return true;
        return false;
    }
}
