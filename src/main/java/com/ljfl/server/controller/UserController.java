package com.ljfl.server.controller;

import com.ljfl.server.biz.UserBiz;
import com.ljfl.server.biz.UserSignBiz;
import com.ljfl.server.converters.UserConverter;
import com.ljfl.server.converters.UserSignConverter;
import com.ljfl.server.dto.UserDTO;
import com.ljfl.server.dto.UserSignDTO;
import com.ljfl.server.vo.base.response.ResponseFactory;
import com.ljfl.server.vo.req.AddUserReq;
import com.ljfl.server.vo.req.IdReq;
import com.ljfl.server.vo.req.OpenidReq;
import com.ljfl.server.vo.req.check.AddUserReqCheck;
import com.ljfl.server.vo.req.check.IdReqCheck;
import com.ljfl.server.vo.req.check.OpenidReqCheck;
import com.ljfl.server.vo.res.UserRes;
import com.ljfl.server.vo.res.UserSignRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/13 21:20
 */
@RestController
@RequestMapping("/http/user")
@Api(value = "用户API介绍", description = "用户API介绍")
public class UserController {

    @Autowired
    private UserBiz userBiz;
    @Autowired
    private UserSignBiz userSignBiz;

    @ApiOperation(value = "【用户】新建用户", httpMethod = "POST", notes = "新建用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@ModelAttribute AddUserReq req) {
        String cRes = AddUserReqCheck.check(req);
        if (StringUtils.isNotBlank(cRes)) {
            return ResponseFactory.buildFailure(cRes);
        }
        UserDTO dto = UserConverter.reqToDTO(req);
        userBiz.addUser(dto);
        return ResponseFactory.buildSuccess("用户创建成功");
    }

    @ApiOperation(value = "【用户】查询用户信息", httpMethod = "GET", notes = "查询用户信息", response = UserRes.class)
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Object get(@ModelAttribute IdReq req) {
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
    public Object isHas(@ModelAttribute OpenidReq req) {
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

    @ApiOperation(value = "【用户】用户签到", httpMethod = "POST", notes = "用户签到")
    @RequestMapping("/sign")
    public Object sign(@ModelAttribute IdReq req) {
        String cRes = IdReqCheck.check(req);
        if (StringUtils.isNotBlank(cRes)) {
            return ResponseFactory.buildFailure(cRes);
        }
        UserSignDTO reqDTO = UserSignConverter.reqToDTO(req);
        userSignBiz.sign(reqDTO);
        return ResponseFactory.buildSuccess("签到成功");
    }

    @ApiOperation(value = "【用户】用户签到列表", httpMethod = "POST", notes = "用户签到列表", response = UserSignRes.class, responseContainer = "List")
    @RequestMapping("/listUserSign")
    public Object listUserSign(@ModelAttribute IdReq req) {
        String cRes = IdReqCheck.check(req);
        if (StringUtils.isNotBlank(cRes)) {
            return ResponseFactory.buildFailure(cRes);
        }
        UserSignDTO reqDTO = UserSignConverter.reqToDTO(req);
        List<UserSignDTO> list = userSignBiz.listUserSign(reqDTO);
        List<UserSignRes> resList = list.stream().map(UserSignConverter::dtoToRes).collect(Collectors.toList());
        return ResponseFactory.buildSuccess(resList);
    }
}
