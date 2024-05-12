package com.niehao.http;

import lombok.Data;

import java.util.Collections;
import java.util.Map;

@Data
public class HttpResult<T> {

    private int code;
    private boolean success;
    private T data;
    private String message;

    private HttpResult(int code, boolean success, T data, String message) {
        this.code = code;
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> HttpResult<T> SUCCESS(T data, String message) {
        return new HttpResult<>(2000, true, data, message);
    }

    public static HttpResult<Map<String, Object>> FAIL(String message) {
        return new HttpResult<>(4000, false, Collections.emptyMap(), message);
    }
}
