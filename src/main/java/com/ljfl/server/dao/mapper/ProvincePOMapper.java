package com.ljfl.server.dao.mapper;

import com.ljfl.server.domain.po.ProvincePO;
import com.ljfl.server.domain.po.ProvincePOExample;
import com.ljfl.server.domain.po.ProvincePOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProvincePOMapper {
    int countByExample(ProvincePOExample example);

    int deleteByExample(ProvincePOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProvincePOWithBLOBs record);

    int insertSelective(ProvincePOWithBLOBs record);

    List<ProvincePOWithBLOBs> selectByExampleWithBLOBs(ProvincePOExample example);

    List<ProvincePO> selectByExample(ProvincePOExample example);

    ProvincePOWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProvincePOWithBLOBs record, @Param("example") ProvincePOExample example);

    int updateByExampleWithBLOBs(@Param("record") ProvincePOWithBLOBs record, @Param("example") ProvincePOExample example);

    int updateByExample(@Param("record") ProvincePO record, @Param("example") ProvincePOExample example);

    int updateByPrimaryKeySelective(ProvincePOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProvincePOWithBLOBs record);

    int updateByPrimaryKey(ProvincePO record);
}