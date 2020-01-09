package com.ljfl.server.service.impl;

import com.ljfl.server.common.constants.UserExceptionConstant;
import com.ljfl.server.common.exceptions.CustomException;
import com.ljfl.server.common.utils.DateUtil;
import com.ljfl.server.common.utils.UUIDUtil;
import com.ljfl.server.converters.UserSignConverter;
import com.ljfl.server.dao.mapper.UserPOMapper;
import com.ljfl.server.dao.mapper.UserSignPOMapper;
import com.ljfl.server.dao.mapper.manual.UserSignPOManualMapper;
import com.ljfl.server.domain.po.UserPO;
import com.ljfl.server.domain.po.UserSignPO;
import com.ljfl.server.dto.UserSignDTO;
import com.ljfl.server.service.UserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 23:16
 */
@Service
public class UserSignServiceImpl implements UserSignService {
    @Autowired
    private UserSignPOMapper userSignPOMapper;
    @Autowired
    private UserSignPOManualMapper userSignPOManualMapper;
    @Autowired
    private UserPOMapper userPOMapper;

    @Override
    public long countSignUser(UserSignDTO dto) {
        String userId = dto.getUserId();
        Date beginDate = dto.getBeginTime();
        Date endDate = dto.getEndTime();
        return userSignPOManualMapper.countSignUser(userId, beginDate, endDate);
    }

    @Override
    public int countContinueSign(UserSignDTO dto) {
        String userId = dto.getUserId();
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        if (userPO == null) {
            throw new CustomException(UserExceptionConstant.empty);
        }
        Date lastSignDate = userPO.getLastSignDate();
        if (DateUtil.dateToStr(lastSignDate).equals(DateUtil.dateToStr(DateUtil.getDateBefore(new Date(), 1)))) {
            if (userPO.getLastSignCount() > 7) {
                userPO.setLastSignCount(7);
            } else {
                userPO.setLastSignCount(userPO.getCount() + 1);
            }
        } else {
            userPO.setLastSignCount(0);
        }
        userPO.setLastSignDate(new Date());
        return userPO.getLastSignCount();
    }

    @Override
    public void sign(UserSignDTO dto) {
        UserSignPO po = UserSignConverter.dtoToPO(dto);
        if (po.getId() == null) po.setId(UUIDUtil.getUUID());
        userSignPOMapper.insertSelective(po);
    }


    public List<UserSignDTO> listUserSign(UserSignDTO dto) {
        String userId = dto.getUserId();
        Date beginDate = dto.getBeginTime();
        Date endDate = dto.getEndTime();
        List<UserSignPO> list = userSignPOManualMapper.listUserSign(userId, beginDate, endDate);
        return list.stream().map(UserSignConverter::poToDTO).collect(Collectors.toList());
    }
}
