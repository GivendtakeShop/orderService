package com.givendtake.orderMicroservice.utilities;

import com.givendtake.orderMicroservice.exceptions.BusinessException;
import com.givendtake.orderMicroservice.exceptions.ExceptionPayload;
import com.givendtake.orderMicroservice.exceptions.ExceptionPayloadFactory;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public interface Assert {
    ExceptionPayload payload = ExceptionPayloadFactory.INVALID_PAYLOAD.get();

    static void assertNotNull(Object value) {
        if (value == null) throw new BusinessException(payload);
    }

    static void assertNotEmpty(String value) {
        if (value == null || value.isEmpty()) throw new BusinessException(payload);
    }

    static void assertRegex(String value, String regex) {
        if (value == null || !Pattern.compile(regex).matcher(value).matches()) throw new BusinessException(payload);
    }

    static void assertMinSize(Collection<?> value, int min) {
        if (value == null || value.size() < min) throw new BusinessException(payload);
    }

    static void assertMinSize(String value, int min) {
        if (value == null || value.length() < min) throw new BusinessException(payload);
    }

    static void assertMaxSize(Collection<?> value, int max) {
        if (value == null || value.size() > max) throw new BusinessException(payload);
    }

    static void assertMaxSize(String value, int max) {
        if (value == null || value.length() > max) throw new BusinessException(payload);
    }

    static void assertPredicate(Predicate<String> predicate, String value, ExceptionPayloadFactory e){
        if(!predicate.test(value))
            throw new BusinessException(e.get());
    }

}
