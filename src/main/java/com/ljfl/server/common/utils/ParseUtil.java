package com.ljfl.server.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ljfl.server.dto.ResponseDTO;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Project:
 * Description:
 * Date: 2019-11-21
 * Copyright: Copyright (c) 2020
 * Company:
 *
 * @author zwx
 * @version 1.0
 */

public class ParseUtil {

    public static HttpGet getMethod(String uri) {
        return getMethod(uri, Collections.emptyMap(), Collections.emptyMap());
    }

    public static HttpGet getMethod(String uri, Map<String, String> paramMap) {
        return getMethod(uri, paramMap, Collections.emptyMap());
    }

    /**
     * 返回get方法 填充前台传送来的参数
     *
     * @param uri      要请求的接口地址
     * @param paramMap 请求参数
     * @author piper
     * @data 2018/7/3 11:19
     */
    public static HttpGet getMethod(String uri, Map<String, String> paramMap, Map<String, String> headMap) {
        try {
            URIBuilder builder = new URIBuilder(uri);
            //将前台的参数放到我的请求里面
            setGetParams(builder, paramMap);
            HttpGet httpGet = new HttpGet(builder.build());
            //将前台的header放到我的请求里面
            setRequestHeads(httpGet, headMap);
            return httpGet;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置httpGet的param
     *
     * @param builder
     * @param paramMap
     */
    private static void setGetParams(URIBuilder builder, Map<String, String> paramMap) {
        paramMap.keySet().forEach(name -> builder.setParameter(name, paramMap.get(name)));
    }

    /**
     * 设置httpGet的HEAD
     *
     * @param httpRequestBase
     * @param headMap
     */
    public static void setRequestHeads(HttpRequestBase httpRequestBase, Map<String, String> headMap) {
        headMap.keySet().forEach(name -> httpRequestBase.addHeader(name, headMap.get(name)));
        Map<String, String> mustHeadMap = getHeadMap();
        mustHeadMap.keySet().forEach(name -> httpRequestBase.addHeader(name, mustHeadMap.get(name)));
    }

    public static HttpPost postMethod(String uri) {
        return postMethod(uri, Collections.emptyMap(), Collections.emptyMap());
    }

    public static HttpPost postMethod(String uri, Map<String, String> paramMap) {
        return postMethod(uri, paramMap, Collections.emptyMap());
    }

    /**
     * 返回post方法
     *
     * @param uri      要请求的地址
     * @param paramMap 请求参数
     * @param headMap  请求header
     * @author piper
     * @data 2018/7/3 11:19
     */
    public static HttpPost postMethod(String uri, Map<String, String> paramMap, Map<String, String> headMap) {
        HttpPost httpPost = new HttpPost(uri);
        setRequestHeads(httpPost, headMap);
        StringEntity entity;
        if (headMap.get("Content-Type") != null && headMap.get("Content-Type").contains("json")) {
            entity = jsonData(paramMap);  //填充json数据
        } else {
            entity = formData(paramMap);  //填充form数据
        }
        setRequestHeads(httpPost, headMap);
        httpPost.setEntity(entity);
        return httpPost;
    }

    /**
     * 设置httpGet的param
     *
     * @param paramMap
     */
    private static UrlEncodedFormEntity setPostParams(Map<String, String> paramMap) {
        UrlEncodedFormEntity urlEncodedFormEntity = null;
        try {
            List<NameValuePair> pairs = new ArrayList<>();  //存储参数
            paramMap.keySet().forEach(name -> {
                pairs.add(new BasicNameValuePair(name, paramMap.get(name)));
            });
            //根据参数创建参数体，以便放到post方法中
            urlEncodedFormEntity = new UrlEncodedFormEntity(pairs);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlEncodedFormEntity;
    }

    /**
     * 处理post请求 form数据 填充form数据
     *
     * @param paramMap 前台请求参数
     * @author piper
     * @data 2018/7/17 18:05
     */
    private static UrlEncodedFormEntity formData(Map<String, String> paramMap) {
        UrlEncodedFormEntity urlEncodedFormEntity = null;
        try {
            List<NameValuePair> pairs = new ArrayList<>();  //存储参数
            paramMap.keySet().forEach(key -> pairs.add(new BasicNameValuePair(key, paramMap.get(key))));
            //根据参数创建参数体，以便放到post方法中
            urlEncodedFormEntity = new UrlEncodedFormEntity(pairs, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlEncodedFormEntity;
    }

    /**
     * 处理post请求 json数据
     *
     * @param paramMap 前台请求参数
     * @author piper
     * @data 2018/7/17 18:05
     */
    private static StringEntity jsonData(Map<String, String> paramMap) {
        //根据json数据创建请求体
        return new StringEntity(JSON.toJSONString(paramMap), "UTF-8");
    }

    public static String getRespContent(CloseableHttpResponse response) throws Exception {
        String respStr;
        try {
            HttpEntity resEntity = response.getEntity();
            respStr = getRespString(resEntity);
            EntityUtils.consume(resEntity);
        } finally {
            response.close();
        }
        return respStr;
    }


    /**
     * 将返回结果转化为String
     *
     * @param entity
     * @return
     * @throws Exception
     */
    public static String getRespString(HttpEntity entity) throws Exception {
        if (entity == null) {
            return null;
        }
        InputStream is = entity.getContent();
        StringBuffer strBuf = new StringBuffer();
        byte[] buffer = new byte[4096];
        int r;
        while ((r = is.read(buffer)) > 0) {
            strBuf.append(new String(buffer, 0, r, "UTF-8"));
        }
        return strBuf.toString();
    }

    public static Map<String, String> getHeadMap() {
        HashMap<String, String> map = new HashMap<>();
        return map;
    }

    public static ResponseDTO parseResponseDTO(String respStr) {
        return JSONObject.parseObject(respStr, ResponseDTO.class);
    }
}
