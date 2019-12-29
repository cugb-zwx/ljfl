package com.ljfl.server.vo.req.check;

import com.ljfl.server.vo.req.IdReq;
import com.ljfl.server.vo.req.check.constant.CheckConstant;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 22:06
 */
public class IdReqCheck {
    public static final String empty_id = "ID不能为空";

    public static String check(IdReq req) {
        if (StringUtils.isBlank(req.getId()))
            return empty_id;
        return CheckConstant.empty_str;
    }
}
