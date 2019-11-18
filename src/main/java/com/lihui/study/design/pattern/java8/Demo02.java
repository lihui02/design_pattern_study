package com.lihui.study.design.pattern.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Demo02
 * @Description: java1.8的foreach
 * @author: ex_lihui4
 * @date: 2019-11-18  15:07
 */

public class Demo02 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.forEach((Integer integer)-> System.out.println(integer));
    }
}
