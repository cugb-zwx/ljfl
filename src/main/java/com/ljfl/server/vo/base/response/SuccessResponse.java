package com.ljfl.server.vo.base.response;

/**
 * @author zwx
 */
public class SuccessResponse extends Response {

    private static final long serialVersionUID = 1025805531285006793L;

    public SuccessResponse() {
        super(success_code);
    }

    public SuccessResponse(String msg) {
        super(success_code, msg);
    }

    public SuccessResponse(Object data) {
        super(success_code, data);
    }

    public SuccessResponse(String msg, Object data) {
        super(success_code, msg, data);
    }
}