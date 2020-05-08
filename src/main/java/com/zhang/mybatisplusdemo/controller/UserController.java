package com.zhang.mybatisplusdemo.controller;

import com.zhang.mybatisplusdemo.exception.CommonException;
import com.zhang.mybatisplusdemo.parameters.operator.UserOperatorParam;
import com.zhang.mybatisplusdemo.response.Result;
import com.zhang.mybatisplusdemo.response.ResultCode;
import com.zhang.mybatisplusdemo.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/9:28
 * @Description:
 */
@RestController
@RequestMapping("/user")
@Api(tags = {"用户模块"})
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 添加用户
     *
     * @param userOperatorParam 用户操作参数
     * @return Result
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户")
    @ApiParam(name = "userOperatorParam", required = true,value = "用户新增操作参数")
    public Result add(@RequestBody UserOperatorParam userOperatorParam) {
        logger.info("开始执行:添加用户的方法");
       // int i  = 1/0;
        //检验参数合法性()这里省略
        userService.add(userOperatorParam);
        logger.info("成功执行:添加用户的方法");
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 更新用户信息
     *
     * @param userOperatorParam 用户操作参数
     * @return Result
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新用户")
    @ApiParam(name = "userOperatorParam", required = true, value = "用户更新操作参数")
    public Result update(@RequestBody UserOperatorParam userOperatorParam) throws CommonException {
        logger.info("开始执行:更新用户的方法");
        //检验参数合法性()这里省略
        userService.update(userOperatorParam);
        logger.info("成功执行:更新用户的方法");
        return new Result(ResultCode.SUCCESS);
    }


}
