package com.ljfl.server.converters;

import com.ljfl.server.domain.po.CustomerOrderPO;
import com.ljfl.server.dto.CustomerOrderDTO;
import com.ljfl.server.vo.req.CreateCustomerOrderReq;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 21:30
 */
public class CustomerOrderConverter {
    public static CustomerOrderDTO reqToDTO(CreateCustomerOrderReq req) {
        if (req == null) {
            return null;
        }
        CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();
        customerOrderDTO.setCustomerMobile(req.getPhone());
        customerOrderDTO.setCity(req.getCity());
        customerOrderDTO.setServiceList(req.getServices());
        return customerOrderDTO;
    }

    public static CustomerOrderPO dtoToPO(CustomerOrderDTO dto) {
        if (dto == null) {
            return null;
        }
        CustomerOrderPO customerOrderPO = new CustomerOrderPO();
        customerOrderPO.setId(dto.getId());
        customerOrderPO.setCustomerMobile(dto.getCustomerMobile());
        customerOrderPO.setCity(dto.getCity());
        customerOrderPO.setServiceList(dto.getServiceList());
        customerOrderPO.setExtInfo(dto.getExtInfo());
        customerOrderPO.setIsDeleted(dto.getIsDeleted());
        customerOrderPO.setAddTime(dto.getAddTime());
        customerOrderPO.setModTime(dto.getModTime());
        return customerOrderPO;
    }
}
