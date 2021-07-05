package com.ljfl.server.dao.mapper;

import com.ljfl.server.domain.po.UserPO;
import com.ljfl.server.domain.po.UserPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPOMapper {
    int countByExample(UserPOExample example);

    int deleteByExample(UserPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    List<UserPO> selectByExampleWithBLOBs(UserPOExample example);

    List<UserPO> selectByExample(UserPOExample example);

    UserPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserPO record, @Param("example") UserPOExample example);

    int updateByExampleWithBLOBs(@Param("record") UserPO record, @Param("example") UserPOExample example);

    int updateByExample(@Param("record") UserPO record, @Param("example") UserPOExample example);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKeyWithBLOBs(UserPO record);

    int updateByPrimaryKey(UserPO record);
}