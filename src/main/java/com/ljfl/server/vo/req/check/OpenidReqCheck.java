package com.ljfl.server.vo.req.check;

import com.ljfl.server.vo.req.OpenidReq;
import com.ljfl.server.vo.req.check.constant.CheckConstant;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 22:14
 */
public class OpenidReqCheck {

    public static String check(OpenidReq req) {
        if (StringUtils.isBlank(req.getOpenid()))
            return CheckConstant.empty_openid;
        return CheckConstant.empty_str;
    }
}
