package com.zhang.mybatisplusdemo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/14:52
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("老师操作参数")
public class Teacher implements Serializable {
    private static final long serialVersionUID = -4544256977940886061L;

    @ApiModelProperty(value = "老师id")
    private Long id;

    @ApiModelProperty(value = "老师名字")
    private String name;
}
