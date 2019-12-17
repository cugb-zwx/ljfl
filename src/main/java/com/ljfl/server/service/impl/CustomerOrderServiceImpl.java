package com.ljfl.server.service.impl;

import com.ljfl.server.converters.CustomerOrderConverter;
import com.ljfl.server.dao.mapper.CustomerOrderPOMapper;
import com.ljfl.server.domain.po.CustomerOrderPO;
import com.ljfl.server.dto.CustomerOrderDTO;
import com.ljfl.server.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 21:24
 */
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderPOMapper customerOrderPOMapper;

    @Override
    public void create(CustomerOrderDTO dto) {
        CustomerOrderPO po = CustomerOrderConverter.dtoToPO(dto);
        customerOrderPOMapper.insertSelective(po);
    }
}
