package com.ccl.rain.common.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.TimestampDeserializer;

import java.io.IOException;
import java.sql.Timestamp;

public class SimpleTimestampDeserializer extends TimestampDeserializer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7397308255405408294L;
	private DateDeserializer dateDeserializer;

	public SimpleTimestampDeserializer() {
		dateDeserializer = new SimpleDateDeserializer();
	}

	public SimpleTimestampDeserializer(DateDeserializer dateDeserializer) {
		this.dateDeserializer = dateDeserializer;
	}

	@Override
	public Timestamp deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new Timestamp(dateDeserializer.deserialize(jp, ctxt).getTime());
	}

}
