package com.lihui.study.algorithms;

import java.util.*;

/**
 * @ClassName: Lesson1
 * @Description: 算法与数据结构   求最大子序列和，比如序列{1，5，-3，4，-6，3}，则最大序列是{1，5，-3，4}，和为7
 * @author: ex_lihui4
 * @date: 2020-3-4  17:47
 */

public class Lesson2 {
    public static void main(String[] args) {
        int[] a=new int[]{-1, 4, -3, 5, 3, -1, 2};
      //  System.out.println(m1(new int[]{-1, 4, -3, 5, 3, -1, 2}));
        System.out.println(m2(a,0,a.length-1));
        List list=new ArrayList();
    }

    //算法1：列出所有的可能性进行比较 时间复杂度 O(N^2)
    public static int m1(int[] arr) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(arr[i]);
            int sumTemp = arr[i];
            if (sumTemp > sum) {
                sum = sumTemp;
                list.add(arr[i]);
            }
            for (int j = i + 1; j < arr.length; j++) {
                sumTemp += arr[j];
                list1.add(arr[j]);
                if (sumTemp > sum) {
                    sum = sumTemp;
                    list.clear();
                    list.addAll(list1);
                }
            }
        }
        System.out.println(list);
        return sum;
    }

    // 分治算法
    private static int m2(int[] arr, int left, int right) {
        if (left == right){
            if (arr[left] > 0)
                return arr[left];
            else return 0;
        }

        int center = (left + right) / 2;
        int maxLeftSum = m2(arr, left, center);
        int maxRightSum = m2(arr, center+1, right);
        int maxLeftBorderSum = 0;
        int LeftBorderSum = 0;
        //计算从中间起，到最左边的最大值
        for (int i = center; i >= left; i--) {
            LeftBorderSum += arr[i];
            if (LeftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = LeftBorderSum;
        }
        int maxRightBorderSum = 0, rightBorderSum = 0;
        //计算从中间起，到最右边的最大值
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += arr[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }
        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int maxLeftSum, int maxRightSum, int i) {
        int max = Math.max(maxLeftSum, maxRightSum);
        return  Math.max(max,i);
    }

}
