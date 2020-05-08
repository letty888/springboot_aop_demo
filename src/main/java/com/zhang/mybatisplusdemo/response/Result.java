package com.zhang.mybatisplusdemo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/9:32
 * @Description: 返回类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("响应报文")
public class Result implements Serializable {
    private static final long serialVersionUID = -759017146021879420L;

    @ApiModelProperty(value = "响应状态码",required = true)
    private Integer code;

    @ApiModelProperty(value = "信息",required = true)
    private String message;

    @ApiModelProperty(value = "数据")
    private Object data;

    @ApiModelProperty(value = "服务器时间")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date now = new Date();


    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
