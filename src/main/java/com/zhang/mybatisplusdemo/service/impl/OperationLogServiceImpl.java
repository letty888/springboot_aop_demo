package com.zhang.mybatisplusdemo.service.impl;

import com.zhang.mybatisplusdemo.mapper.OperationLogMapper;
import com.zhang.mybatisplusdemo.pojo.OperationLog;
import com.zhang.mybatisplusdemo.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/13:52
 * @Description:
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    private final OperationLogMapper operationLogMapper;

    public OperationLogServiceImpl(OperationLogMapper operationLogMapper) {
        this.operationLogMapper = operationLogMapper;
    }

    /**
     * 添加操作日志
     * @param operationLog 操作日志
     */
    @Override
    public void add(OperationLog operationLog) {
        operationLogMapper.insert(operationLog);
    }
}
