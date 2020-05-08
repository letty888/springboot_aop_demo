package com.zhang.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.mybatisplusdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/9:21
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
