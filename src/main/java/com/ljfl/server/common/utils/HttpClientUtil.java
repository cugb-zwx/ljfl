package com.ljfl.server.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ljfl.server.dto.ResponseDTO;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/15 19:40
 */
public class HttpClientUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    public static ResponseDTO sendGet(String url, Map<String, Object> params) {
        return sendGet(url, getParams(params));
    }

    /**
     * 发送GET请求
     *
     * @param url               请求url
     * @param nameValuePairList 请求参数
     * @return JSON或者字符串
     * @throws Exception
     */
    public static ResponseDTO sendGet(String url, List<NameValuePair> nameValuePairList) {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            /**
             * 创建HttpClient对象
             */
            client = HttpClients.createDefault();
            /**
             * 创建URIBuilder
             */
            URIBuilder uriBuilder = new URIBuilder(url);
            /**
             * 设置参数
             */
            uriBuilder.addParameters(nameValuePairList);
            /**
             * 创建HttpGet
             */
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            /**
             * 设置请求头部编码
             */
            httpGet.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
            /**
             * 设置返回编码
             */
            httpGet.setHeader(new BasicHeader("Accept", "application/json;charset=utf-8"));
            /**
             * 请求服务
             */
            response = client.execute(httpGet);
            /**
             * 获取response中的内容
             */
            String respStr = getResponseStr(response);
            /**
             * respStr转换为结果对象
             */
            return JSONObject.parseObject(respStr, ResponseDTO.class);
        } catch (Exception e) {
            LOGGER.error("方法: {},参数：{}，异常信息{}", "sendGet", JSON.toJSONString(nameValuePairList), e.getMessage());
        } finally {
            try {
                response.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error("方法: {},参数：{}，异常信息{}", "sendGet", JSON.toJSONString(nameValuePairList), e.getMessage());
            }
        }
        return new ResponseDTO();
    }

    public static ResponseDTO sendPost(String url, Map<String, Object> params) {
        return sendPost(url, getParams(params));
    }

    /**
     * 发送POST请求
     *
     * @param url
     * @param nameValuePairList
     * @return JSON或者字符串
     * @throws Exception
     */
    public static ResponseDTO sendPost(String url, List<NameValuePair> nameValuePairList) {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            /**
             *  创建一个httpclient对象
             */
            client = HttpClients.createDefault();
            /**
             * 创建一个post对象
             */
            HttpPost post = new HttpPost(url);
            /**
             * 包装成一个Entity对象
             */
            StringEntity entity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
            /**
             * 设置请求的内容
             */
            post.setEntity(entity);
            /**
             * 设置请求的报文头部的编码
             */
            //post.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
            post.setHeader(new BasicHeader("Content-Type", "application/json;charset=UTF-8"));
            /**
             * 设置请求的报文头部的编码
             */
            post.setHeader(new BasicHeader("Accept", "application/json;charset=utf-8"));
            /**
             * 执行post请求
             */
            response = client.execute(post);
            /**
             * 获取response中的内容
             */
            String respStr = getResponseStr(response);
            /**
             * respStr转换为结果对象
             */
            return JSONObject.parseObject(respStr, ResponseDTO.class);
        } catch (Exception e) {
            LOGGER.error("方法: {},参数：{}，异常信息{}", "sendPost", JSON.toJSONString(nameValuePairList), e.getMessage());
        } finally {
            try {
                response.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error("方法: {},参数：{}，异常信息{}", "sendPost", JSON.toJSONString(nameValuePairList), e.getMessage());
            }
        }
        return new ResponseDTO();
    }

    private static List<NameValuePair> getParams(Map<String, Object> params) {
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            nameValuePairList.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
        }
        return nameValuePairList;
    }

    private static String getResponseStr(HttpResponse response) throws IOException {
        // 读取为 InputStream，在网页内容数据量大时候推荐使用
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }
}
