package com.ljfl.server.dao.mapper.manual;

import com.ljfl.server.domain.po.UserPO;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 11:47
 */
public interface UserPOManualMapper {
    UserPO getUser(@Param("openid") String openid);
}
