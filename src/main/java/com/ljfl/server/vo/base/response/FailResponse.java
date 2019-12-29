package com.ljfl.server.vo.base.response;

/**
 * @author zwx
 */
public class FailResponse extends Response {

    private static final long serialVersionUID = -8891202807508737483L;

    public FailResponse() {
        super(fail_code);
    }

    public FailResponse(String msg) {
        super(fail_code, msg);
    }

    public FailResponse(Object data) {
        super(fail_code, data);
    }

    public FailResponse(String msg, Object data) {
        super(fail_code, msg, data);
    }

}