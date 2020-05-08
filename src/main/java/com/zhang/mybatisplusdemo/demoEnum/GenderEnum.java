package com.zhang.mybatisplusdemo.demoEnum;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/9:04
 * @Description:
 */
public enum GenderEnum implements IEnum<Integer> {

    MAN(0, "男"),
    WOMEN(1, "女");

    private int value;
    private String description;

    GenderEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }


    @Override
    public String toString() {
        return this.description;
    }
}
