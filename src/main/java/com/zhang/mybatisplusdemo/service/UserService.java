package com.zhang.mybatisplusdemo.service;

import com.zhang.mybatisplusdemo.exception.CommonException;
import com.zhang.mybatisplusdemo.parameters.operator.UserOperatorParam;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/9:21
 * @Description:
 */
public interface UserService {

    /**
     * 添加用户
     * @param userOperatorParam 用户操作参数
     */
    void add(UserOperatorParam userOperatorParam);

    /**
     * 更新用户
     * @param userOperatorParam 用户操作参数
     */
    void update(UserOperatorParam userOperatorParam) throws CommonException;
}
