package com.ljfl.server.dao.mapper;

import com.ljfl.server.domain.po.UserGarbagePO;
import com.ljfl.server.domain.po.UserGarbagePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGarbagePOMapper {
    int countByExample(UserGarbagePOExample example);

    int deleteByExample(UserGarbagePOExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserGarbagePO record);

    int insertSelective(UserGarbagePO record);

    List<UserGarbagePO> selectByExample(UserGarbagePOExample example);

    UserGarbagePO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserGarbagePO record, @Param("example") UserGarbagePOExample example);

    int updateByExample(@Param("record") UserGarbagePO record, @Param("example") UserGarbagePOExample example);

    int updateByPrimaryKeySelective(UserGarbagePO record);

    int updateByPrimaryKey(UserGarbagePO record);
}