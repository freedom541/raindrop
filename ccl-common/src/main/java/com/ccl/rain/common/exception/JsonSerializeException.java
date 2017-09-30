package com.ccl.rain.common.exception;


public class JsonSerializeException extends BeanSerializeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2058733498406297653L;

	public JsonSerializeException() {
	}

	public JsonSerializeException(String message) {
		super(message);
	}

	public JsonSerializeException(Throwable cause) {
		super(cause);
	}

	public JsonSerializeException(String message, Throwable cause) {
		super(message, cause);
	}

}
