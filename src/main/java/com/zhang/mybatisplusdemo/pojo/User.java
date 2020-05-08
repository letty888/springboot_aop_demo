package com.zhang.mybatisplusdemo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.zhang.mybatisplusdemo.demoEnum.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/8:54
 * @Description: user实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_demo")
public class User implements Serializable {
    private static final long serialVersionUID = 2691233622818663196L;

    @TableId
    private Long id;

    private String username;

    private Integer age;

    private GenderEnum gender;

    //@TableField(update = "now()")
    //更新时间也可以在数据库中指定
    private Date updateTime;

    private Date createTime;

    @Version
    private Integer version;

    /**
     *  1:删除   0:未删除
     */
    @TableLogic
    private Integer deleted;

}
