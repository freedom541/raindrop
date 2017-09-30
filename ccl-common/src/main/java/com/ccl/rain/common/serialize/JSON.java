package com.ccl.rain.common.serialize;

import com.google.common.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class JSON {
    private static BeanSerializable jacksonBeanSerializable = JacksonJsonSerializable
            .getInstance();
    private static BeanSerializable xstreamBeanSerializable = XStreamJsonSerializable
            .getInstance();

    public static String toString(Object bean) throws BeanSerializeException {
        return jacksonBeanSerializable.bean2str(bean);
    }

    public static String toStringWriteHeader(Object bean)
            throws BeanSerializeException {
        return xstreamBeanSerializable.bean2str(bean);
    }

    public static <T> T toBean(String str, Class<T> type)
            throws BeanSerializeException {
        return jacksonBeanSerializable.str2bean(str, type);
    }

    public static <T> T toBeanWithHeader(String str, Class<T> type)
            throws BeanSerializeException {
        return xstreamBeanSerializable.str2bean(str, type);
    }

    public static <T> T toBean(String str, Class<T> type, Class<?> content)
            throws BeanSerializeException {
        if (null == content) {
            return jacksonBeanSerializable.str2bean(str, type);
        }
        return jacksonBeanSerializable.str2bean(str, type, content);
    }

    public static <T> T toBean(String str, Type type)
            throws BeanSerializeException {
        return jacksonBeanSerializable.str2bean(str, type);
    }

    public static <T> T toBean(String str, TypeToken<T> type)
            throws BeanSerializeException {
        return jacksonBeanSerializable.str2bean(str, type);
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        System.out.println(JSON.toString(map));
    }
}
