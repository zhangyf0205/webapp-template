package com.xx.xx.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;

/**
 * Created by Shrimp on 16/9/10.
 */
@Provider
public class JacksonConfigurator implements ContextResolver<ObjectMapper> {

    private ObjectMapper mapper = new ObjectMapper();
    public JacksonConfigurator() {
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    @Override
    public ObjectMapper getContext(Class<?> arg0) {
        return mapper;
    }
}
