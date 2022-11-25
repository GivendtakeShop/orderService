package com.givendtake.orderService.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;

public interface JSONUtil {
    ObjectMapper objectMapper = new ObjectMapper();


    @SneakyThrows
    static String toJSON(Object object) {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(object);
    }
}


