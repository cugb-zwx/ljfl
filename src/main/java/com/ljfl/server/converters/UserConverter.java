package com.ljfl.server.converters;

import com.ljfl.server.common.utils.DateUtil;
import com.ljfl.server.domain.po.UserPO;
import com.ljfl.server.dto.UserDTO;
import com.ljfl.server.vo.req.AddUserReq;
import com.ljfl.server.vo.req.CodeReq;
import com.ljfl.server.vo.req.IdReq;
import com.ljfl.server.vo.res.UserRes;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 21:30
 */
public class UserConverter {
    public static UserDTO reqToDTO(AddUserReq req) {
        if (req == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setName(req.getName());
        userDTO.setNickName(req.getNickName());
        userDTO.setHeadImg(req.getHeadImg());
        userDTO.setPassward(req.getPassward());
        userDTO.setPassward2(req.getPassward2());
        userDTO.setCode(req.getCode());
        userDTO.setSex(req.getSex());
        userDTO.setAge(req.getAge());
        userDTO.setCityCode(req.getCityCode());
        userDTO.setMobile(req.getMobile());
        userDTO.setIsDelete(req.getIsDelete());
        userDTO.setNote(req.getNote());
        return userDTO;
    }

    public static UserDTO reqToDTO(IdReq req) {
        if (req == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(req.getId());
        return userDTO;
    }

    public static UserDTO reqToDTO(CodeReq req) {
        if (req == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setCode(req.getCode());
        return userDTO;
    }

    public static UserPO dtoToPO(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        UserPO userPO = new UserPO();
        userPO.setId(dto.getId());
        userPO.setName(dto.getName());
        userPO.setNickName(dto.getNickName());
        userPO.setHeadImg(dto.getHeadImg());
        userPO.setPassward(dto.getPassward());
        userPO.setOpenid(dto.getOpenid());
        userPO.setSex(Byte.valueOf("0").equals(dto.getSex()) ? false : true);
        userPO.setAge(dto.getAge());
        userPO.setLoginTime(DateUtil.longToDate(dto.getLoginTime()));
        userPO.setCityCode(dto.getCityCode());
        userPO.setMobile(dto.getMobile());
        userPO.setCount(dto.getCount());
        userPO.setIsDelete(dto.getIsDelete());
        userPO.setCreateTime(DateUtil.longToDate(dto.getCreateTime()));
        userPO.setUpdateTime(DateUtil.longToDate(dto.getUpdateTime()));
        userPO.setPoints(dto.getPoints());
        userPO.setNote(dto.getNote());
        return userPO;
    }

    public static UserDTO poToDTO(UserPO po) {
        if (po == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(po.getId());
        userDTO.setName(po.getName());
        userDTO.setNickName(po.getNickName());
        userDTO.setHeadImg(po.getHeadImg());
        userDTO.setPassward(po.getPassward());
        userDTO.setOpenid(po.getOpenid());
        userDTO.setSex(Boolean.FALSE.equals(po.getSex()) ? Byte.valueOf("0") : Byte.valueOf("1"));
        userDTO.setAge(po.getAge());
        userDTO.setLoginTime(DateUtil.dateToLong(po.getLoginTime()));
        userDTO.setCityCode(po.getCityCode());
        userDTO.setMobile(po.getMobile());
        userDTO.setCount(po.getCount());
        userDTO.setIsDelete(po.getIsDelete());
        userDTO.setCreateTime(DateUtil.dateToLong(po.getCreateTime()));
        userDTO.setUpdateTime(DateUtil.dateToLong(po.getUpdateTime()));
        userDTO.setPoints(po.getPoints());
        userDTO.setNote(po.getNote());
        return userDTO;
    }

    public static UserRes dtoToRes(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        UserRes userRes = new UserRes();
        userRes.setId(dto.getId());
        userRes.setName(dto.getName());
        userRes.setNickName(dto.getNickName());
        userRes.setHeadImg(dto.getHeadImg());
        userRes.setSex(Byte.valueOf("0").equals(dto.getSex()) ? false : true);
        userRes.setAge(dto.getAge());
        userRes.setLoginTime(dto.getLoginTime());
        userRes.setCityCode(dto.getCityCode());
        userRes.setMobile(dto.getMobile());
        userRes.setCount(dto.getCount());
        userRes.setIsDelete(dto.getIsDelete());
        userRes.setCreateTime(dto.getCreateTime());
        userRes.setUpdateTime(dto.getUpdateTime());
        userRes.setPoints(dto.getPoints());
        userRes.setNote(dto.getNote());
        return userRes;
    }
}
