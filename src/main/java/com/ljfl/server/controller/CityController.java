package com.ljfl.server.controller;

import com.ljfl.server.biz.GarbageOneBiz;
import com.ljfl.server.biz.CityBiz;
import com.ljfl.server.biz.GarbageTwoBiz;
import com.ljfl.server.converters.GarbageOneConverter;
import com.ljfl.server.converters.CityConverter;
import com.ljfl.server.converters.GarbageTwoConverter;
import com.ljfl.server.converters.GovFileConverter;
import com.ljfl.server.dto.GarbageOneDTO;
import com.ljfl.server.dto.CityDTO;
import com.ljfl.server.dto.GarbageTwoDTO;
import com.ljfl.server.dto.GovFileDTO;
import com.ljfl.server.vo.base.response.ResponseFactory;
import com.ljfl.server.vo.req.GarbageOneReq;
import com.ljfl.server.vo.req.GarbageTwoReq;
import com.ljfl.server.vo.req.GovFileReq;
import com.ljfl.server.vo.res.CityRes;
import com.ljfl.server.vo.res.GarbageOneRes;
import com.ljfl.server.vo.res.GarbageTwoRes;
import com.ljfl.server.vo.res.GovFileRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @Description: java类作用描述
 * @Author: lhj
 * @CreateDate: 2019/12/30 21:20
 */
@RestController
@RequestMapping("/http/city")
@Api(value = "城市API介绍", description = "城市API介绍")
public class CityController {

    @Autowired
    private CityBiz cityBiz;
    @Autowired
    private GarbageOneBiz garbageOneBiz;
    @Autowired
    private GarbageTwoBiz garbageTwoBiz;

    @ApiOperation(value = "【城市】城市列表查询", httpMethod = "GET", notes = "城市列表查询", response = CityRes.class, responseContainer = "List")
    @RequestMapping(value = "/listCity", method = RequestMethod.GET)
    public Object listCity() {
        List<CityDTO> list = cityBiz.list();
        List<CityRes> resList = list.stream().map(CityConverter::dtoToRes).collect(Collectors.toList());
        List<Map<String, List<Object>>> letter = cityBiz.op(resList);
        return ResponseFactory.buildSuccess(letter);
    }

    @ApiOperation(value = "【城市】垃圾类别列表查询", httpMethod = "GET", notes = "垃圾类别列表查询", response = GarbageOneRes.class, responseContainer = "List")
    @RequestMapping(value = "/listCate", method = RequestMethod.GET)
    public Object listCate(@ModelAttribute GarbageOneReq req) {
        GarbageOneDTO reqDTO = GarbageOneConverter.reqToDTO(req);
        List<GarbageOneDTO> list = garbageOneBiz.list(reqDTO);
        List<GarbageOneRes> resList = list.stream().map(GarbageOneConverter::dtoToRes).collect(Collectors.toList());
        return ResponseFactory.buildSuccess(resList);
    }

    @ApiOperation(value = "【城市】垃圾列表查询", httpMethod = "GET", notes = "垃圾列表查询", response = GarbageTwoRes.class, responseContainer = "List")
    @RequestMapping(value = "/listGarbage", method = RequestMethod.GET)
    public Object listGarbage(@ModelAttribute GarbageTwoReq req) {
        GarbageTwoDTO reqDTO = GarbageTwoConverter.reqToDTO(req);
        List<GarbageTwoDTO> list = garbageTwoBiz.list(reqDTO);
        List<GarbageTwoRes> resList = list.stream().map(GarbageTwoConverter::dtoToRes).collect(Collectors.toList());
        return ResponseFactory.buildSuccess(resList);
    }

    @ApiOperation(value = "【城市】官方文件查询", httpMethod = "GET", notes = "官方文件查询", response = GovFileRes.class, responseContainer = "List")
    @RequestMapping(value = "/listGovFile", method = RequestMethod.GET)
    public Object listGovFile(@ModelAttribute GovFileReq req) {
        GovFileDTO reqDTO = GovFileConverter.reqToDTO(req);
        List<GovFileDTO> list = cityBiz.listGov(reqDTO);
        List<GovFileRes> resList = list.stream().map(GovFileConverter::dtoToRes).collect(Collectors.toList());
        return ResponseFactory.buildSuccess(resList);
    }


}
