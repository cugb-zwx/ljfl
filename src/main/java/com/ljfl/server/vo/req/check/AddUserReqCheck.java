package com.ljfl.server.vo.req.check;

import com.ljfl.server.vo.req.AddUserReq;
import com.ljfl.server.vo.req.check.constant.CheckConstant;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 22:19
 */
public class AddUserReqCheck {

    public static final String empty_name = "用户姓名不能为空";
    public static final String empty_nickName = "用户昵称不能为空";

    public static String check(AddUserReq req) {
        if (StringUtils.isBlank(req.getCode())) return CheckConstant.empty_openid;
        if (StringUtils.isBlank(req.getName())) return empty_name;
        if (StringUtils.isBlank(req.getNickName())) return empty_nickName;
        return CheckConstant.empty_str;
    }
}
