package com.ljfl.server.dao.mapper;

import com.ljfl.server.domain.po.CityPO;
import com.ljfl.server.domain.po.CityPOExample;
import com.ljfl.server.domain.po.CityPOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityPOMapper {
    int countByExample(CityPOExample example);

    int deleteByExample(CityPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CityPOWithBLOBs record);

    int insertSelective(CityPOWithBLOBs record);

    List<CityPOWithBLOBs> selectByExampleWithBLOBs(CityPOExample example);

    List<CityPO> selectByExample(CityPOExample example);

    CityPOWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CityPOWithBLOBs record, @Param("example") CityPOExample example);

    int updateByExampleWithBLOBs(@Param("record") CityPOWithBLOBs record, @Param("example") CityPOExample example);

    int updateByExample(@Param("record") CityPO record, @Param("example") CityPOExample example);

    int updateByPrimaryKeySelective(CityPOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CityPOWithBLOBs record);

    int updateByPrimaryKey(CityPO record);
}