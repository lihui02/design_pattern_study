package com.lihui.study.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: Demo01
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-1-17  9:10
 */

public class Demo01 {
    static {
        System.out.println("Ffffffffffffff");
    }

    public static void main(String[] args) {
        /**
         * parallel（）  开启并行流
         */
        long time = new Date().getTime();
        Optional<Integer>  max= Stream.iterate(1,x->x+1).limit(200).parallel().peek(x->{
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(Thread.currentThread().getName());
        }).max(Integer::compare);
        long endTime=new Date().getTime();
        /**
         * sequential() 顺序流
         */
        Optional<Integer> min = Stream.iterate(1, x -> x + 1).limit(200).sequential().peek(x -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //System.out.println(Thread.currentThread().getName());
        }).max(Integer::compare);
        long endTime1=new Date().getTime();
        System.out.println(endTime-time);
        System.out.println(endTime1-endTime);

    }
}


class User{
    private String name;
    private int age;
    private boolean gender;

    public User() {
    }

    public User(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getAge() == user.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge());
    }
}