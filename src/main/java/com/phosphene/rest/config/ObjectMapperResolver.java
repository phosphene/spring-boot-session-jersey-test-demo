package com.phosphene.rest.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.Version;
import com.phosphene.rest.view.*;

@Provider
public class ObjectMapperResolver implements ContextResolver<ObjectMapper> {
    
    final ObjectMapper defaultMapper;
    final ObjectMapper customMapper;

    public ObjectMapperResolver() {
        customMapper = createCustomObjectMapper();
        defaultMapper = createDefaultObjectMapper();
    }

    @Override
        public ObjectMapper getContext(Class<?> type) {
        return  customMapper;
     }


    private static ObjectMapper createDefaultObjectMapper() {

        return new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
            .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
            .setAnnotationIntrospector(createJaxbJacksonAnnotationIntrospector());
    }


    private static ObjectMapper createCustomObjectMapper() {

                
        return new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false)
            .setAnnotationIntrospector(createJaxbJacksonAnnotationIntrospector());
    }
    

    private static AnnotationIntrospector createJaxbJacksonAnnotationIntrospector() {

        final AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
        final AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();

        return AnnotationIntrospector.pair(jacksonIntrospector, jaxbIntrospector);
    }

}
