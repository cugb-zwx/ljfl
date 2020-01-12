package com.ljfl.server.dao.mapper.manual;

import com.ljfl.server.domain.po.UserSignPO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 11:47
 */
public interface UserSignPOManualMapper {

    long countSignUser(@Param("userId") String userId, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

    List<UserSignPO> listUserSign(@Param("userId") String userId, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);
}
