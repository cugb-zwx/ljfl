package com.ljfl.server.dto;

import com.alibaba.fastjson.JSONObject;
import com.ljfl.server.common.enums.CommonCodeEnum;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/15 19:51
 */
public class ResponseDTO {
    private JSONObject error;
    private Boolean success;
    private JSONObject data;

    public boolean isFail() {
        return !isSuccess();
    }

    public boolean isSuccess() {
        return success != null && success;
    }

    private JSONObject getResult() {
        if (isSuccess()) return data;
        return error;
    }

    public String getMessage() {
        JSONObject result = getResult();
        if (result != null) return result.getString("message");
        return CommonCodeEnum.INTERNAL_ERROR.getMessage();
    }

    public Integer getCode() {
        JSONObject result = getResult();
        if (result != null) return result.getInteger("code");
        return CommonCodeEnum.INTERNAL_ERROR.getCode();
    }

    public JSONObject getError() {
        return error;
    }

    public void setError(JSONObject error) {
        this.error = error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
