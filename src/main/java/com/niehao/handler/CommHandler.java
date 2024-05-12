package com.niehao.handler;

import com.niehao.error.UserException;
import com.niehao.http.HttpResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class CommHandler {

    @ExceptionHandler(UserException.class)
    public HttpResult<Map<String, Object>> error(Throwable e) {
        return HttpResult.FAIL(e.getLocalizedMessage());
    }

}
