package com.ccl.rain.common.serialize;

import com.ccl.rain.common.exception.BadRequestException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;

import java.io.IOException;

/**
 * Created ccl
 */
public class DateTimeDeserializer extends JsonDeserializer<DateTime> {
    @Override
    public DateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String text = jp.getText();
        DateTime dateTime;
        try {
            dateTime = new DateTime(text);
        } catch (Exception e) {
            throw new BadRequestException("DateTime format is not \"yyyy-MM-dd'T'HH:mm:ss'Z'\"", e, "Jupiter.Validation.DateTime.FormatError");
        }
        return dateTime;
    }

}
