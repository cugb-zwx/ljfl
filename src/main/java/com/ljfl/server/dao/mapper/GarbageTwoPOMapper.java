package com.ljfl.server.dao.mapper;

import com.ljfl.server.domain.po.GarbageTwoPO;
import com.ljfl.server.domain.po.GarbageTwoPOExample;
import com.ljfl.server.domain.po.GarbageTwoPOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GarbageTwoPOMapper {
    int countByExample(GarbageTwoPOExample example);

    int deleteByExample(GarbageTwoPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(GarbageTwoPOWithBLOBs record);

    int insertSelective(GarbageTwoPOWithBLOBs record);

    List<GarbageTwoPOWithBLOBs> selectByExampleWithBLOBs(GarbageTwoPOExample example);

    List<GarbageTwoPO> selectByExample(GarbageTwoPOExample example);

    GarbageTwoPOWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GarbageTwoPOWithBLOBs record, @Param("example") GarbageTwoPOExample example);

    int updateByExampleWithBLOBs(@Param("record") GarbageTwoPOWithBLOBs record, @Param("example") GarbageTwoPOExample example);

    int updateByExample(@Param("record") GarbageTwoPO record, @Param("example") GarbageTwoPOExample example);

    int updateByPrimaryKeySelective(GarbageTwoPOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GarbageTwoPOWithBLOBs record);

    int updateByPrimaryKey(GarbageTwoPO record);
}