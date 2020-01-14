package com.ljfl.server.remote.weixin;

import com.alibaba.fastjson.JSON;
import com.ljfl.server.common.utils.HttpClientUtil;
import com.ljfl.server.common.utils.HttpsClientUtil;
import com.ljfl.server.common.utils.ParseUtil;
import com.ljfl.server.remote.weixin.res.WeiXinLoginRes;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2020/1/14 23:22
 */
@Component
public class WeixinLoginUtil {

    private static String loginUrl;

    private static String appid;

    private static String secret;

    private static String grantType;

    public static WeiXinLoginRes login(String code) {
        Map<String, String> paramMap = getParamMap();
        paramMap.put("code", code);
        String resp = HttpsClientUtil.sendGet(loginUrl, paramMap, Collections.emptyMap());
        return JSON.parseObject(resp, WeiXinLoginRes.class);
    }

    private static Map<String, String> getParamMap() {
        Map<String, String> map = new HashMap<>();
        map.put("appid", appid);
        map.put("secret", secret);
        map.put("grant_type", grantType);
        return map;
    }

    @Value("${wx.loginUrl}")
    public void setLoginUrl(String loginUrl) {
        WeixinLoginUtil.loginUrl = loginUrl;
    }

    @Value("${wx.appid}")
    public void setAppid(String appid) {
        WeixinLoginUtil.appid = appid;
    }

    @Value("${wx.secret}")
    public void setSecret(String secret) {
        WeixinLoginUtil.secret = secret;
    }

    @Value("${wx.grantType}")
    public void setGrantType(String grantType) {
        WeixinLoginUtil.grantType = grantType;
    }
}
