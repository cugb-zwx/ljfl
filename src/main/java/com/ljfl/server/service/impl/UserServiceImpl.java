package com.ljfl.server.service.impl;

import com.ljfl.server.common.constants.UserExceptionConstant;
import com.ljfl.server.common.exceptions.CustomException;
import com.ljfl.server.common.utils.UUIDUtil;
import com.ljfl.server.converters.UserConverter;
import com.ljfl.server.dao.mapper.UserPOMapper;
import com.ljfl.server.dao.mapper.manual.UserPOManualMapper;
import com.ljfl.server.domain.po.UserPO;
import com.ljfl.server.dto.UserDTO;
import com.ljfl.server.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public String login(UserDTO dto) {
        UserPO userPO = getUserByOpenid(dto.getOpenid());
        if (userPO == null) {
            throw new CustomException(UserExceptionConstant.empty);
        }
        return userPO.getId();
    }

    private UserPO getUserByOpenid(String openid) {
        if (StringUtils.isBlank(openid)) return null;
        return userPOManualMapper.getUserByOpenid(openid);
    }

    @Override
    public String addUser(UserDTO dto) {
        if (dto.getId() == null) dto.setId(UUIDUtil.getUUID());
        UserPO po = UserConverter.dtoToPO(dto);
        userPOMapper.insertSelective(po);
        return po.getId();
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (StringUtils.isBlank(dto.getId())) addUser(dto);
        UserPO po = UserConverter.dtoToPO(dto);
        userPOMapper.updateByPrimaryKeySelective(po);
    }

    @Override
    public UserDTO getUser(UserDTO dto) {
        String id = dto.getId();
        UserPO po = userPOMapper.selectByPrimaryKey(id);
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
