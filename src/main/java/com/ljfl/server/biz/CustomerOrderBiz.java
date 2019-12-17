package com.ljfl.server.biz;

import com.ljfl.server.dto.CustomerOrderDTO;
import com.ljfl.server.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 21:22
 */
@Service
@Transactional
public class CustomerOrderBiz {

    @Autowired
    private CustomerOrderService customerOrderService;

    public void create(CustomerOrderDTO dto) {
        customerOrderService.create(dto);
    }
}
