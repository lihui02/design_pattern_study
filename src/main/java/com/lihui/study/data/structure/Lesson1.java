package com.lihui.study.data.structure;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Lesson1
 * @Description: 算法与数据结构  练习题
 * @author: ex_lihui4
 * @date: 2020-3-4  17:47
 */

public class Lesson1 {
    private static int num=0;
    public static void main(String[] args) {
        System.out.println(findMaxByIndex1(new int[]{1, 6, 3, 5, 8, 3,2,7}, 4));
    }

    //题目1.1解法1：求N个数的第k个最大者   冒泡排序
    //时间复杂度O)(N*k)
    public static int findMaxByIndex(int[] arr, int k) {
        for (int i = arr.length - 1; i > arr.length-1-k; i--) {
            for (int j = 0; j < i; j++) {
                num++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
         System.out.println(Arrays.toString(arr));
        System.out.println(num);
        return arr[arr.length - k];
    }

    // 题目1.1解法2： 求N个数的第k个最大者   选择排序
    //时间复杂度O)(N*k)
    public static int findMaxByIndex1(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                num++;
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(num);
        System.out.println(Arrays.toString(arr));
        return arr[k-1];
    }
}
