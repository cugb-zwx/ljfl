package com.ljfl.server.controller;

import com.ljfl.server.biz.UserBiz;
import com.ljfl.server.converters.UserConverter;
import com.ljfl.server.dto.UserDTO;
import com.ljfl.server.vo.base.response.ResponseFactory;
import com.ljfl.server.vo.req.AddUserReq;
import com.ljfl.server.vo.req.IdReq;
import com.ljfl.server.vo.req.OpenidReq;
import com.ljfl.server.vo.req.check.AddUserReqCheck;
import com.ljfl.server.vo.req.check.IdReqCheck;
import com.ljfl.server.vo.req.check.OpenidReqCheck;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 21:20
 */
@RestController
@RequestMapping("/http/user")
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @ApiOperation(value = "【用户】新建用户", httpMethod = "POST", notes = "新建用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(AddUserReq req) {
        String cRes = AddUserReqCheck.check(req);
        if (StringUtils.isNotBlank(cRes)) {
            return ResponseFactory.buildFailure(cRes);
        }
        UserDTO dto = UserConverter.reqToDTO(req);
        userBiz.addUser(dto);
        return ResponseFactory.buildSuccess("用户创建成功");
    }

    @ApiOperation(value = "【用户】查询用户信息", httpMethod = "GET", notes = "查询用户信息")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Object get(IdReq req) {
        String cRes = IdReqCheck.check(req);
        if (StringUtils.isNotBlank(cRes)) {
            return ResponseFactory.buildFailure(cRes);
        }
        UserDTO reqDTO = UserConverter.reqToDTO(req);
        UserDTO resDTO = userBiz.getUser(reqDTO);
        if (resDTO == null) {
            return ResponseFactory.buildFailure("该用户信息不存在");
        }
        return ResponseFactory.buildSuccess(UserConverter.dtoToRes(resDTO));
    }

    @ApiOperation(value = "【用户】检测用户", httpMethod = "GET", notes = "检测用户是否存在")
    @RequestMapping("/isHas")
    public Object isHas(OpenidReq req) {
        String cRes = OpenidReqCheck.check(req);
        if (StringUtils.isNotBlank(cRes)) {
            return ResponseFactory.buildFailure(cRes);
        }
        UserDTO reqDTO = UserConverter.reqToDTO(req);
        boolean res = userBiz.isHasUser(reqDTO);
        if (res) {
            return ResponseFactory.buildFailure("用户已存在");
        }
        return ResponseFactory.buildSuccess("用户不存在");
    }
}
