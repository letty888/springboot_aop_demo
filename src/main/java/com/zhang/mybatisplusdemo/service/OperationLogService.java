package com.zhang.mybatisplusdemo.service;

import com.zhang.mybatisplusdemo.pojo.OperationLog;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/13:51
 * @Description:
 */
public interface OperationLogService {

    /**
     * 添加操作日志
     * @param operationLog 操作日志
     */
    void add(OperationLog operationLog);
}
