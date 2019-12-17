package com.ljfl.server.controller;

import com.ljfl.server.biz.CustomerOrderBiz;
import com.ljfl.server.converters.CustomerOrderConverter;
import com.ljfl.server.dto.CustomerOrderDTO;
import com.ljfl.server.vo.ResponseFactory;
import com.ljfl.server.vo.req.CreateCustomerOrderReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 21:20
 */
@RestController
@RequestMapping("/customer/order")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderBiz customerOrderBiz;

    @RequestMapping("/create")
    public Object create(CreateCustomerOrderReq req) {
        CustomerOrderDTO dto = CustomerOrderConverter.reqToDTO(req);
        customerOrderBiz.create(dto);
        return ResponseFactory.buildSuccess("下单成功啦");
    }
}
