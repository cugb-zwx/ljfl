package com.ljfl.server.dao.mapper;

import com.ljfl.server.domain.po.GarbageOnePO;
import com.ljfl.server.domain.po.GarbageOnePOExample;
import com.ljfl.server.domain.po.GarbageOnePOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GarbageOnePOMapper {
    int countByExample(GarbageOnePOExample example);

    int deleteByExample(GarbageOnePOExample example);

    int deleteByPrimaryKey(String id);

    int insert(GarbageOnePOWithBLOBs record);

    int insertSelective(GarbageOnePOWithBLOBs record);

    List<GarbageOnePOWithBLOBs> selectByExampleWithBLOBs(GarbageOnePOExample example);

    List<GarbageOnePO> selectByExample(GarbageOnePOExample example);

    GarbageOnePOWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GarbageOnePOWithBLOBs record, @Param("example") GarbageOnePOExample example);

    int updateByExampleWithBLOBs(@Param("record") GarbageOnePOWithBLOBs record, @Param("example") GarbageOnePOExample example);

    int updateByExample(@Param("record") GarbageOnePO record, @Param("example") GarbageOnePOExample example);

    int updateByPrimaryKeySelective(GarbageOnePOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GarbageOnePOWithBLOBs record);

    int updateByPrimaryKey(GarbageOnePO record);
}