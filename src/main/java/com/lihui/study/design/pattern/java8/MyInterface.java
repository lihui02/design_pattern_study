package com.lihui.study.design.pattern.java8;

/**
 * @ClassName: MyInterface
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-11-18  14:26
 */
@FunctionalInterface
public interface MyInterface<F,T> {
    T m1(F f);
}
