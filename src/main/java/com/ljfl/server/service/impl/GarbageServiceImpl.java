package com.ljfl.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ljfl.server.common.utils.HttpClientUtil;
import com.ljfl.server.common.utils.UUIDUtil;
import com.ljfl.server.converters.GarbageQueryConverter;
import com.ljfl.server.converters.GarbageTwoConverter;
import com.ljfl.server.dao.mapper.GarbageTwoPOMapper;
import com.ljfl.server.domain.po.GarbageTwoPO;
import com.ljfl.server.domain.po.GarbageTwoPOExample;
import com.ljfl.server.domain.po.GarbageTwoPOWithBLOBs;
import com.ljfl.server.dto.GarbageQueryDTO;
import com.ljfl.server.dto.GarbageTwoDTO;
import com.ljfl.server.dto.ResponseDTO;
import com.ljfl.server.service.GarbageService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.hash.Hashing;
import java.nio.charset.Charset;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sec on 2020-1-7.
 */
@Service
public class GarbageServiceImpl implements GarbageService {
    @Autowired
    private GarbageTwoPOMapper garbageTwoPOMapper;

    @Override
    public List<GarbageQueryDTO>txtsearch(GarbageQueryDTO dto) {
        GarbageTwoPOExample poExample =new GarbageTwoPOExample();
        GarbageTwoPOExample.Criteria criteria = poExample.createCriteria();
        criteria.andCityCodeEqualTo(dto.getCityCode());
        criteria.andNameEqualTo(dto.getName());
        List<GarbageTwoPOWithBLOBs> list =garbageTwoPOMapper.selectByExampleWithBLOBs(poExample);
        return list.stream().map(GarbageQueryConverter::poToDTO).collect(Collectors.toList());
    }


    @Override
    public List<GarbageQueryDTO> picsearch(GarbageQueryDTO dto) {

        String apiUrl = "https://aiapi.jd.com/jdai/garbageImageSearch";
        String appkey="3189d4385ef1ddae1b7e7453a7cc56ba";
        String secretKey = "92be05b65eab00beb1e1c08be18c41c2";
        long timestamp = System.currentTimeMillis();
        String sign = Hashing.md5().hashString(secretKey + timestamp, Charset.forName("UTF-8")).toString();

        Map<String, String> params =new LinkedHashMap<>();
        params.put("appkey",appkey);
        params.put("timestamp",String.valueOf(timestamp));
        params.put("sign",sign);
        String url= getRqstUrl(apiUrl,params);

        List<NameValuePair> pairs = new ArrayList<>();
        NameValuePair pair1 = new BasicNameValuePair("imgBased64", String.valueOf(dto.getImgBase64()));
        NameValuePair pair2 = new BasicNameValuePair("cityCode", String.valueOf(dto.getId()));
        pairs.add(pair1);
        pairs.add(pair2);

        ResponseDTO rs = HttpClientUtil.sendPost(url,pairs);
        List<GarbageQueryDTO> dms = new ArrayList<>();
        List<GarbageTwoDTO> dts = new ArrayList<>();
        if(rs.isSuccess()) {
            JSONObject jsonObject = rs.getData();
            String result = jsonObject.getString("result");
            JSONObject jsonObjects = JSON.parseObject(result);
            //String status = jsonObjects.getString("status");
            JSONArray ja = jsonObjects.getJSONArray("garbage_info");
            for (int i = 0; i < ja.size(); i++) {
                GarbageTwoDTO dt= new GarbageTwoDTO();
                GarbageQueryDTO dm= new GarbageQueryDTO();
                dt.setCityCode(ja.getJSONObject(i).getString("cate_id"));
                dt.setName(ja.getJSONObject(i).getString("garbage_name"));
                dt.setReMark(ja.getJSONObject(i).getString("ps"));
                dts.add(dt);
                dm.setCityCode(ja.getJSONObject(i).getString("cate_id"));
                dm.setName(ja.getJSONObject(i).getString("garbage_name"));
                dm.setReMark(ja.getJSONObject(i).getString("ps"));
                dms.add(dm);
            }
            for (GarbageTwoDTO dt : dts) {
                //加判断
                addGarbage(dt);
            }
        }
        return dms ;
    }

    /**
     * 拼接get请求的url请求地址
     */
    public  String getRqstUrl(String url, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(url);
        boolean isFirst = true;
        for (String key : params.keySet()) {
            if (key != null && params.get(key) != null) {
                if (isFirst) {
                    isFirst = false;
                    builder.append("?");
                } else {
                    builder.append("&");
                }
                builder.append(key)
                        .append("=")
                        .append(params.get(key));
            }
        }
        return builder.toString();
    }




    @Override
    public void addGarbage(GarbageTwoDTO dto) {
        GarbageTwoPOWithBLOBs po = GarbageTwoConverter.dtoToPO(dto);
        if (po.getId() == null) po.setId(UUIDUtil.getUUID());
        garbageTwoPOMapper.insertSelective(po);
    }

    @Override
    public void updateGarbage(GarbageTwoDTO dto) {
        if (StringUtils.isBlank(dto.getId())) addGarbage(dto);
        GarbageTwoPOWithBLOBs po = GarbageTwoConverter.dtoToPO(dto);
        garbageTwoPOMapper.updateByPrimaryKeySelective(po);
    }

}
