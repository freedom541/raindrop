package com.ccl.rain.common.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.LocalTime;

import java.io.IOException;

/**
 * Created by ccl on 2017/8/6.
 */
public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {
    @Override
    public LocalTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String text = jp.getText();
        LocalTime localDate = new LocalTime(text);
        return localDate;
    }
}
