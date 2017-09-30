package com.ccl.rain.common.serialize;

import com.google.common.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import java.lang.reflect.Type;

public class XStreamJsonSerializable implements BeanSerializable {
	private XStream xstream;
	private static XStreamJsonSerializable singleInstance;

	private XStreamJsonSerializable() {
		xstream = new XStream(new JettisonMappedXmlDriver());
//		xstream.setMode(XStream.NO_REFERENCES);
	}

	public synchronized static XStreamJsonSerializable getInstance() {
		if (null == singleInstance) {
			singleInstance = new XStreamJsonSerializable();
		}
		return singleInstance;
	}

	@Override
	public String bean2str(Object bean) throws BeanSerializeException {
		return xstream.toXML(bean);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T str2bean(String str, Class<T> type)
			throws BeanSerializeException {
		T bean = (T) xstream.fromXML(str);
		return bean;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T str2bean(String str, Class<T> type, Class<?> content)
			throws BeanSerializeException {
		T bean = (T) xstream.fromXML(str);
		return bean;
	}

    @Override
    public <T> T str2bean(String str, Type type) throws BeanSerializeException {
        T bean = (T) xstream.fromXML(str);
        return bean;
    }

    @Override
	@SuppressWarnings("unchecked")
	public <T> T str2bean(String str, TypeToken<T> type)
			throws BeanSerializeException {
		T bean = (T) xstream.fromXML(str);
		return bean;
	}

}
