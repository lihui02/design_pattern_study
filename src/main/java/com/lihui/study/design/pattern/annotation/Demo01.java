package com.lihui.study.design.pattern.annotation;

/**
 * @ClassName: Demo01
 * @Description: 测试注解
 * @author: ex_lihui4
 * @date: 2019-11-18  14:48
 */

public class Demo01 {
    public static void main(String[] args) {

    }
    @MyAnnotation
    private void m1(){
        System.out.println(11);
        //  错误从commit  push
    }
}
