/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.serialize;

import br.com.altamira.data.model.Entity;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;

/**
 *
 * @author Alessandro
 */
public class NullProvider extends DefaultSerializerProvider {

    public NullProvider() {
        super();
    }

    public NullProvider(NullProvider base, SerializationConfig config, SerializerFactory jsf) {
        super(base, config, jsf);
    }

    @Override
    public DefaultSerializerProvider createInstance(SerializationConfig config, SerializerFactory jsf) {
        return new NullProvider(this, config, jsf);
    }

    @Override
    public JsonSerializer<Object> findNullValueSerializer(BeanProperty property)
            throws JsonMappingException {
        if (property.getClass().equals(Entity.class)) {
            return new NullObjectSerializer();
        }
        return super.findNullValueSerializer(property);
    }
}
