package com.ccl.rain.common.serialize;

import com.google.common.reflect.TypeToken;

import java.lang.reflect.Type;

public interface BeanSerializable {
	String bean2str(Object bean) throws BeanSerializeException;

	<T> T str2bean(String str, Class<T> type) throws BeanSerializeException;

	<T> T str2bean(String str, Class<T> type, Class<?> content)
			throws BeanSerializeException;

    <T> T str2bean(String str, Type type) throws BeanSerializeException;

	<T> T str2bean(String str, TypeToken<T> type) throws BeanSerializeException;
}
