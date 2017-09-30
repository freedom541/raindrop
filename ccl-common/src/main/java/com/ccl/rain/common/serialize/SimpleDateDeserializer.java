package com.ccl.rain.common.serialize;

import com.ccl.rain.common.utils.DataTypeConvertUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

import java.io.IOException;
import java.util.Date;

public class SimpleDateDeserializer extends DateDeserializer {

    /**
     *
     */
    private static final long serialVersionUID = 162800339949328475L;

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonToken t = jp.getCurrentToken();
        if (t == JsonToken.VALUE_NUMBER_INT) {
            return new Date(jp.getLongValue());
        }
        if (t == JsonToken.VALUE_NULL) {
            return getNullValue();
        }
        if (t == JsonToken.VALUE_STRING) {
            try {
                /*
                 * As per [JACKSON-203], take empty Strings to mean null
				 */
                String str = jp.getText().trim();
                if (str.length() == 0) {
                    return getEmptyValue();
                }
                return DataTypeConvertUtils.convert(str, Date.class);
            } catch (IllegalArgumentException iae) {
                throw ctxt.instantiationException(
                        _valueClass,
                        "not a valid representation (error: "
                                + iae.getMessage() + ")");
            }
        }
        throw ctxt.mappingException(_valueClass, t);
    }

}
