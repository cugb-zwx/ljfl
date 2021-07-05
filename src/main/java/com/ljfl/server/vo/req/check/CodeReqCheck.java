package com.ljfl.server.vo.req.check;

import com.ljfl.server.vo.req.CodeReq;
import com.ljfl.server.vo.req.check.constant.CheckConstant;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 22:06
 */
public class CodeReqCheck {
    public static final String empty_code = "微信code不能为空";

    public static String check(CodeReq req) {
        if (StringUtils.isBlank(req.getCode()))
            return empty_code;
        return CheckConstant.empty_str;
    }
}
