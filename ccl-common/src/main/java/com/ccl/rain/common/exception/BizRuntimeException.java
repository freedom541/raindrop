package com.ccl.rain.common.exception;


/**
 * All runtime exceptions inside framework should inherit from this
 *
 * @author ccl
 */
public class BizRuntimeException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 4395547434330678738L;

    private final ResponseCode code;

    private final String errorCode;

    public BizRuntimeException(String message, ResponseCode code, String errorCode) {
        super(message);
        this.code = code;
        this.errorCode = errorCode;
    }

    public BizRuntimeException(String message, Throwable cause, ResponseCode code, String errorCode) {
        super(message, cause);
        this.code = code;
        this.errorCode = errorCode;
    }

    public ResponseCode getCode() {
        return code;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
