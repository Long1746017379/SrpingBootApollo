package com.example.apollo.config;

import com.example.apollo.entity.ResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionConfig {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseBean nullException(Exception exception) {
        log.error("[ Exception 全局异常捕获 ] " + exception.getMessage());
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode("error");
        responseBean.setMessage(exception.getMessage());
        return responseBean;
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseBean throwCustomException(MethodArgumentNotValidException methodArgumentNotValidException) {
        log.error("[ @Vaild异常捕获 ] " + methodArgumentNotValidException.getMessage());
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode("error");
        responseBean.setMessage(methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
        return responseBean;
    }

    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public ResponseBean byZero(ArithmeticException arithmeticException) {
        log.error("[ ArithmeticException 异常捕获 ] " + arithmeticException.getMessage());
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode("error");
        responseBean.setMessage(arithmeticException.getMessage());
        return responseBean;
    }

    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public ResponseBean nullException(NullPointerException nullPointerException) {
        log.error("[ NullPointerException 异常捕获 ] " + nullPointerException.getMessage());
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode("error");
        responseBean.setMessage(nullPointerException.getMessage());
        return responseBean;
    }


}
