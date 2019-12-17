package com.ljfl.server.vo;

/**
 * 返回下述形式的JSON对应的数据格式 <br>
 * { <br>
 * "error" : {<br>
 * "code" : 401, // code 仅用于表示有错误，相同的 code 可能有不同的 type 和 message <br>
 * "type" : "PermissionDenied", // type表示真正的错误类型，错误类型的唯一标示 <br>
 * "message" : "抱歉，你没有足够的权限" // 错误对应的详细说明，和type成对。可以理解type是title，message是body <br>
 * }<br>
 * }<br>
 *
 * @author niexiao
 */
public class FailResponse extends BaseObject {
    private ResponseMsg error = null;

    public FailResponse() {
    }

    public FailResponse(Integer code, String type, String message) {
        error = new ResponseMsg(code, type, message);
    }

    public FailResponse(ResponseMsg error) {
        this.error = error;
    }

    public ResponseMsg getError() {
        return error;
    }

    public void setError(ResponseMsg error) {
        this.error = error;
    }
}