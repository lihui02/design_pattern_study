package com.lihui.study.data.algorithm;

import java.util.Arrays;

/**
 * @ClassName: Sort
 * @Description: 排序算法
 * @author: ex_lihui4
 * @date: 2020-3-25  15:00
 */

public class Sort {
    /**
     * 插入排序，讲数组氛围已排序和未排序两部分。每次从未排序拿出一个元素，插入已排序的合适位置
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
           int temp=arr[i];
            for (int j = 0; j < i; j++) {
                if (temp<arr[j]){
                    for (int k=j;k<i+1;k++,j++){
                        int temp1=arr[j];
                        arr[j]=temp;
                        temp=temp1;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{11,3,6,2};
        Sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
