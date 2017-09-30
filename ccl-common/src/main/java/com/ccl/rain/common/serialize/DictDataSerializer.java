package com.ccl.rain.common.serialize;

import com.ccl.rain.common.DictData;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;

import java.io.IOException;

/**
 * Created by ccl on 2017/8/18.
 */
public class DictDataSerializer extends StdScalarSerializer<DictData> {
    public DictDataSerializer() {
        super(DictData.class);
    }

    @Override
    public void serialize(DictData value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        if (null == value) {
            jgen.writeNull();
        } else {
            jgen.writeNumber(value.getValue());
        }
    }
}
