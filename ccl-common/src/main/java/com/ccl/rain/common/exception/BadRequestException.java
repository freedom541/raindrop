package com.ccl.rain.common.exception;

/**
 * 不正确的请求
 *
 * @author ccl
 */
public class BadRequestException extends BizRuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -3625633233926549521L;

    public BadRequestException(String message, String errorCode) {
        this(message, null, errorCode);
    }

    public BadRequestException(String message, Throwable t, String errorCode) {
        super(message, t, ResponseCode.BAD_REQUEST, errorCode);
    }

}
