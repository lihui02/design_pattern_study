package com.lihui.study.localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName: Demo01
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-1-18  11:29
 */

public class Demo01 {
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
        System.out.println(today);
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
       // today.pa
    }
}
