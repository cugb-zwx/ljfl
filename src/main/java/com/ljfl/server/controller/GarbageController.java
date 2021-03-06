package com.ljfl.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.ljfl.server.biz.GarbageBiz;
import com.ljfl.server.common.utils.HttpClientUtil;
import com.ljfl.server.converters.GarbageQueryConverter;
import com.ljfl.server.converters.GarbageTwoConverter;
import com.ljfl.server.domain.po.GarbageTwoPO;
import com.ljfl.server.dto.GarbageQueryDTO;
import com.ljfl.server.dto.GarbageTwoDTO;
import com.ljfl.server.dto.ResponseDTO;
import com.ljfl.server.service.GarbageTwoService;
import com.ljfl.server.vo.base.response.ResponseFactory;
import com.ljfl.server.vo.req.AddGarbageReq;
import com.ljfl.server.vo.req.GarbageQueryReq;
import com.ljfl.server.vo.res.GarbageQueryRes;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Created by sec on 2020-1-7.
 */
@RestController
@RequestMapping("/http/garbage")
public class GarbageController {
    @Autowired
    private GarbageBiz garbageBiz;

    @ApiOperation(value = "【垃圾】文本识别搜索", httpMethod = "GET", notes = "文本识别搜索")
    @RequestMapping(value = "/txtSearch", method = RequestMethod.GET)
    public Object txtSearch(GarbageQueryReq req) {
        GarbageQueryDTO reqDTO = GarbageQueryConverter.reqToDTO(req);
        List<GarbageQueryDTO> list = garbageBiz.txtsearch(reqDTO);
        List<GarbageQueryRes> resList = list.stream().map(GarbageQueryConverter::dtoToRes).collect(Collectors.toList());
        if (resList.size() == 0) {
            return ResponseFactory.buildFailure("相关垃圾分类信息不存在");
        }
        return ResponseFactory.buildSuccess(resList);
    }

    @ApiOperation(value = "【垃圾】图片识别搜索", httpMethod = "POST", notes = "图片识别搜索")
    @RequestMapping(value = "/picSearch", method = RequestMethod.POST)
    public Object picSearch(GarbageQueryReq req) {
        GarbageQueryDTO reqDTO = GarbageQueryConverter.reqToDTO(req);
        List<GarbageQueryDTO>  list = garbageBiz.picsearch(reqDTO);
        List<GarbageQueryRes> resList = list.stream().map(GarbageQueryConverter::dtoToRes).collect(Collectors.toList());
        if (resList.size() == 0) {
            return ResponseFactory.buildFailure("相关垃圾分类信息不存在");
        }
        return ResponseFactory.buildSuccess(resList);
    }



    @ApiOperation(value = "【垃圾】添加垃圾信息", httpMethod = "POST", notes = "添加垃圾信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(AddGarbageReq req) {
        GarbageTwoDTO dto = GarbageTwoConverter.reqToDTO(req);
        garbageBiz.addGarbage(dto);
        return ResponseFactory.buildSuccess("添加成功");
    }

    @ApiOperation(value = "【垃圾】编辑垃圾信息", httpMethod = "POST", notes = "编辑垃圾信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(AddGarbageReq req) {
        GarbageTwoDTO dto = GarbageTwoConverter.reqToDTO(req);
        garbageBiz.updateGarbage(dto);
        return ResponseFactory.buildSuccess("修改成功");
    }

}
