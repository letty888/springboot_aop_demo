package com.zhang.mybatisplusdemo.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/9:50
 * @Description: 自定义异常类
 */
@Setter
@Getter
public class CommonException extends Exception {
    private static final long serialVersionUID = -3556349649366387675L;

    private String message;

    public CommonException(String message) {
        this.message =message;
    }


}
