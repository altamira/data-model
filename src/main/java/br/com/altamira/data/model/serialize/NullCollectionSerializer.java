package br.com.altamira.data.model.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 *
 * @author alessandro.holanda
 */
public class NullCollectionSerializer extends JsonSerializer<Object> {

    ObjectWriter writer;

    /**
     *
     */
    public NullCollectionSerializer() {
        ObjectMapper objectMapper = new ObjectMapper();
        Hibernate4Module hibernateModule = new Hibernate4Module();
        hibernateModule.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
        hibernateModule.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
        objectMapper.registerModule(hibernateModule);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.getSerializerProvider().setNullValueSerializer(new NullValueSerializer());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        writer = objectMapper.writer();
    }

    /**
     *
     * @param value
     * @param jsonGenerator
     * @param provider
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public void serialize(Object value, JsonGenerator jsonGenerator,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {
        if (value == null) {
            jsonGenerator.writeString("[]");
        } else {
            writer.writeValue(jsonGenerator, value);
        }

    }
}
