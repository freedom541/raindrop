package com.ccl.rain.common.serialize;

import com.ccl.rain.common.exception.JsonSerializeException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.google.common.reflect.TypeToken;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Date;

public class JacksonJsonSerializable implements BeanSerializable {

    private ObjectMapper mapper;

    private static JacksonJsonSerializable singleInstance;

    private JacksonJsonSerializable() {
        mapper = new ObjectMapper();
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
        AnnotationIntrospector introspector1 = new JacksonAnnotationIntrospector();
        AnnotationIntrospector annotationIntrospector = AnnotationIntrospector
                .pair(introspector, introspector1);
        mapper.setAnnotationIntrospector(annotationIntrospector);
        configMapper(mapper);

    }

    public static void configMapper(ObjectMapper mapper) {
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleModule simpleModole = new SimpleModule("SimpleModule");
        simpleModole.addSerializer(new DictDataSerializer());
        simpleModole.addSerializer(Date.class, new SimpleDateSerializer());
        simpleModole.addSerializer(DateTime.class, new DateTimeSerializer());
        simpleModole.addSerializer(LocalDate.class, new LocalDateSerializer());
        simpleModole.addSerializer(LocalTime.class, new LocalTimeSerializer());

        SimpleDateDeserializer dateDeserializer = new SimpleDateDeserializer();
        SimpleTimestampDeserializer timestampDeserializer = new SimpleTimestampDeserializer(
                dateDeserializer);
        simpleModole.addDeserializer(Timestamp.class, timestampDeserializer);
        simpleModole.addDeserializer(Date.class, dateDeserializer);
        simpleModole.addDeserializer(DateTime.class, new DateTimeDeserializer());
        simpleModole.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        simpleModole.addDeserializer(LocalTime.class, new LocalTimeDeserializer());
        mapper.registerModule(simpleModole);
    }

    public synchronized static JacksonJsonSerializable getInstance() {
        if (null == singleInstance) {
            singleInstance = new JacksonJsonSerializable();
        }
        return singleInstance;
    }

    @Override
    public String bean2str(Object bean) throws JsonSerializeException {
        try {
            String json = mapper.writeValueAsString(bean);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonSerializeException("Serialize bean to json error", e);
        }
    }

    @Override
    public <T> T str2bean(String str, Class<T> type)
            throws JsonSerializeException {
        try {
            T bean = mapper.readValue(str, type);
            return bean;
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonSerializeException("Deserialize json to bean error",
                    e);
        }
    }

    @Override
    public <T> T str2bean(String str, Class<T> type, Class<?> content)
            throws BeanSerializeException {
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(type,
                    content);
            T bean = mapper.readValue(str, javaType);
            return bean;
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonSerializeException("Deserialize json to bean error",
                    e);
        }
    }

    @Override
    public <T> T str2bean(String str, Type type) throws BeanSerializeException {
        try {
            JavaType javaType = mapper.getTypeFactory().constructType(type);
            T bean = mapper.readValue(str, javaType);
            return bean;
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonSerializeException("Deserialize json to bean error",
                    e);
        }
    }

    @Override
    public <T> T str2bean(String str, TypeToken<T> type)
            throws JsonSerializeException {
        try {
            JavaType javaType = mapper.getTypeFactory().constructType(
                    type.getType());
            T bean = mapper.readValue(str, javaType);
            return bean;
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonSerializeException("Deserialize json to bean error",
                    e);
        }
    }

}
