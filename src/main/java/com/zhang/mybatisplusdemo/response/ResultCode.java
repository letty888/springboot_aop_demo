package com.zhang.mybatisplusdemo.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/9:34
 * @Description:
 */
@Getter
public enum ResultCode {


    SUCCESS(200, "操作成功"),
    FAILED(601,"操作失败"),
    SYS_ERROR(500,"系统异常");

    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;


    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
