package com.thoughtworks.examonline.common.tech.utils;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public final class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();
    private static final String JSON_STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    static {
        mapper.configure(WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(FAIL_ON_EMPTY_BEANS, false);
        mapper.setDateFormat(new SimpleDateFormat(JSON_STANDARD_FORMAT));
        mapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JsonUtils() { }

    public static <T> String toJson(final T o) throws IOException {
        return mapper.writeValueAsString(o);
    }

    public static <T> String toJson(final List<T> lists) throws IOException {
        return mapper.writeValueAsString(lists);
    }

    public static <T> T toClass(final String json, final Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }
}
