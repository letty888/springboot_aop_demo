package com.zhang.mybatisplusdemo.service.impl;

import com.zhang.mybatisplusdemo.demoEnum.GenderEnum;
import com.zhang.mybatisplusdemo.exception.CommonException;
import com.zhang.mybatisplusdemo.mapper.UserMapper;
import com.zhang.mybatisplusdemo.parameters.operator.UserOperatorParam;
import com.zhang.mybatisplusdemo.pojo.User;
import com.zhang.mybatisplusdemo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/9:25
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 添加用户
     *
     * @param userOperatorParam 用户操作参数
     */
    @Override
    public void add(UserOperatorParam userOperatorParam) {
        User user = new User();
        BeanUtils.copyProperties(userOperatorParam, user);
        userMapper.insert(user);
    }


    /**
     * 更新用户
     *
     * @param userOperatorParam 用户操作参数
     */
    @Override
    public void update(UserOperatorParam userOperatorParam) throws CommonException {

        User userDb = userMapper.selectById(userOperatorParam.getId());
        if (userDb == null) {
            throw new CommonException("抱歉,没有对应数据!");
        }
        BeanUtils.copyProperties(userOperatorParam, userDb);
        userMapper.updateById(userDb);
    }
}
