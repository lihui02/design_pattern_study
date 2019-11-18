package com.lihui.study.design.pattern.java8;

/**
 * @ClassName: Demo01
 * @Description: lambda表达式的用法
 * @author: ex_lihui4
 * @date: 2019-11-18  14:26
 */

public class Demo01 {
    public static void main(String[] args) {
        MyInterface<String,Integer> myInterface=(a)->Integer.valueOf(a);
        Integer integer = myInterface.m1("123");
        System.out.println(integer);

        MyInterface<String,Integer> myInterface1=Integer::valueOf;
        Integer integer1 = myInterface.m1("1234");
        System.out.println(integer1);

    }
}
