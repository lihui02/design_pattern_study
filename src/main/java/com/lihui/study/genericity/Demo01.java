package com.lihui.study.genericity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * @ClassName: Demo01
 * @Description: 泛型
 * @author: ex_lihui4
 * @date: 2020-2-27  14:25
 */

public class Demo01<T> {
    public <V> void m1(V v)  {
        System.out.println(v);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Demo01<Integer> demo01=new Demo01<>();
        StringBuilder builder=new StringBuilder();
        builder.toString();
        demo01.m1("dd");
        demo01.m1(111);
    }
}
class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1=new Solution1();
        List<String> list = solution1.generateParenthesis(3);
        System.out.println(list);

    }
    public List<String> generateParenthesis(int n) {
        return m1(n);
    }

    private List<String> m1(int q){
        List<String> list=new ArrayList<>();
        if (1==q){
            list.add("()");
        }else{
            for(int i=0;i<q;i++){
               String s=null;
                if (i==0){
                     s="()";
                }else {
                    for (String s1:m1(i)){
                        s = "(" + s1 + ")";
                    }
                }
                if (q-i-1==0){
                    list.add(s);
                }else {
                    for (String s2:m1(q-i-1)){
                        if (q-i-1!=0)
                            s =s+s2;
                        list.add(s);
                    }
                }
            }
        }
      return list;
    }
}

