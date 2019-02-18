package com.java.rest.shop.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonHelper {

    /**
     * Configured to not close streams.
     */
    public static final ObjectMapper MAPPER; // Threadsafe since Jackson docs say: can reuse, share globally

    /**
     * Configured to not close streams.
     */
    public static final JsonFactory JSON_FACTORY;

    static {
        MAPPER = new ObjectMapper();

        // Configure teh mapper to allow for additional fields to be generated by the service, allows for additive updates without up-rev
        MAPPER.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // We don't want to close the streams passed in to this class.
        // This means that any streams created by this class must be closed explicitly within finally blocks
        MAPPER.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);

        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JSON_FACTORY = new JsonFactory();
        JSON_FACTORY.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        JSON_FACTORY.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
    }

    private JacksonHelper() {
        // static methods on this class mean that it should not be instantiated
    }

    /**
     * Returns a String containing the JSON representation of the Object passed.
     *
     * @param value
     * @return
     */
    public static String convertToJSON(Object value) throws IOException {

        if (value == null) {
            return "";
        }

        StringWriter stringWriter = new StringWriter();
        try {

            MAPPER.writeValue(stringWriter, value);

            stringWriter.flush();
            return stringWriter.toString();
        }
        finally {
            stringWriter.close();

        }
    }

    /**
     * Expects a String such as "{"first":"1", "second":1}" and a Class of the type of Object encoded in the String.
     *
     * @param objectAsJson
     * @param clazz
     * @return
     */
    public static <T> T getObjectFromJson(String objectAsJson, Class<T> clazz) throws IOException {

        return MAPPER.readValue(objectAsJson, clazz);

    }

    public static <T> T getObjectListFromJson(String objectAsJson, Class<?> clazz) throws IOException {

        if (objectAsJson == null) {
            return (T) new ArrayList();
        }

        return MAPPER.readValue(objectAsJson, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));

    }

    public static Map<String, String> getStringMapFromJson(String objectAsJson) throws IOException {

        if (objectAsJson == null) {
            return new HashMap<>();
        }

        return MAPPER.readValue(objectAsJson, MAPPER.getTypeFactory().constructMapType(Map.class, String.class, String.class));

    }
}