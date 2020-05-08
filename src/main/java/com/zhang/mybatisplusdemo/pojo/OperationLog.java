package com.zhang.mybatisplusdemo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/13:12
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("operation_log")
public class OperationLog implements Serializable {
    private static final long serialVersionUID = 1306116025205046461L;

    private Long id;
    private String remoteAddr;
    private Date operateTime;
    private Long operateUserId;
    private String operateClass;
    private String operateMethod;
    private String paramAndValue;
    private Long costTime;
    private String returnClass;
    private String returnValue;
    private String operatorResult;
}
