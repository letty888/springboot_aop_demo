package com.zhang.mybatisplusdemo.exception;

import com.zhang.mybatisplusdemo.response.Result;
import com.zhang.mybatisplusdemo.response.ResultCode;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/9:56
 * @Description: 全局异常处理类
 */
//@RestControllerAdvice
/*public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result exceptionOne(Exception e){
        if(e instanceof CommonException){
            return new Result(501,e.getMessage());
        }
        return new Result(ResultCode.SYS_ERROR);
    }
}*/
