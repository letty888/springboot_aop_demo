package com.zhang.mybatisplusdemo.parameters.operator;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.zhang.mybatisplusdemo.demoEnum.GenderEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/9:24
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("添加,更新 用户操作参数")
public class UserOperatorParam implements Serializable {
    private static final long serialVersionUID = 8169518014633882440L;

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @ApiModelProperty(value = "用户性别",notes = "0: 男    1:女")
    private GenderEnum gender;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    /**
     * 1:删除   0:未删除
     */
    @ApiModelProperty(value = "是否删除   1:删除   0:未删除 ")
    private Integer deleted;
}
