package com.ljfl.server.dao.mapper;

import com.ljfl.server.domain.po.CustomerOrderPO;
import com.ljfl.server.domain.po.CustomerOrderPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerOrderPOMapper {
    int countByExample(CustomerOrderPOExample example);

    int deleteByExample(CustomerOrderPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerOrderPO record);

    int insertSelective(CustomerOrderPO record);

    List<CustomerOrderPO> selectByExample(CustomerOrderPOExample example);

    CustomerOrderPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerOrderPO record, @Param("example") CustomerOrderPOExample example);

    int updateByExample(@Param("record") CustomerOrderPO record, @Param("example") CustomerOrderPOExample example);

    int updateByPrimaryKeySelective(CustomerOrderPO record);

    int updateByPrimaryKey(CustomerOrderPO record);
}