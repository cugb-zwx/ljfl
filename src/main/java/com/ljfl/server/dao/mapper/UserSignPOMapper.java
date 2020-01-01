package com.ljfl.server.dao.mapper;

import com.ljfl.server.domain.po.UserSignPO;
import com.ljfl.server.domain.po.UserSignPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSignPOMapper {
    int countByExample(UserSignPOExample example);

    int deleteByExample(UserSignPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserSignPO record);

    int insertSelective(UserSignPO record);

    List<UserSignPO> selectByExample(UserSignPOExample example);

    UserSignPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserSignPO record, @Param("example") UserSignPOExample example);

    int updateByExample(@Param("record") UserSignPO record, @Param("example") UserSignPOExample example);

    int updateByPrimaryKeySelective(UserSignPO record);

    int updateByPrimaryKey(UserSignPO record);
}