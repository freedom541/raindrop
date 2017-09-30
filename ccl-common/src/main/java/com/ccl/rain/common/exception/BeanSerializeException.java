package com.ccl.rain.common.exception;

public class BeanSerializeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8446655901886399546L;

	public BeanSerializeException() {
	}

	public BeanSerializeException(String message) {
		super(message);
	}

	public BeanSerializeException(Throwable cause) {
		super(cause);
	}

	public BeanSerializeException(String message, Throwable cause) {
		super(message, cause);
	}

}
