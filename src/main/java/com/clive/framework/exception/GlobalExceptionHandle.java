package com.clive.framework.exception;


import com.clive.common.result.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;


@RestControllerAdvice
public class GlobalExceptionHandle {


/*    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public CommonResult SqlDuplicateException(SQLIntegrityConstraintViolationException e){
        return  CommonResult.fail("姓名重复");
    }*/
}
