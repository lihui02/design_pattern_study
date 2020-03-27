package com.lihui.study.data.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName: Sort
 * @Description: 三种基本排序算法:
 * 冒泡排序：最坏情况——比较次数(n-1)+(n-2)+(n-3)+...+1=n*(n-1)/2，每次都要交换，最坏的时间复杂度是O(N^2)；
 *          最好情况——只比较第一轮，也就是n-1次，没有元素进行交换，说明已经是有序的，最好的时间复杂度是O(N)；
 *          平均情况——平均时间复杂度是O(N^2)。
 *          只有临时变量temp占用空间，空间复杂度O(1)。
 *          稳定算法，不会交换两个相同元素的相对位置
 * 选择排序：最坏情况——比较次数(n-1)+(n-2)+(n-3)+...+1=n*(n-1)/2,每轮比较交换一次，也就是n-1次，最坏的时间复杂度是O(N^2)；
 *          最好情况——比较n*(n-1)/2次，不需要进行交换，最好的时间复杂度也是O(N^2)；
 *          平均情况——平均时间复杂度是O(N^2)。
 *          只有临时变量minIndex占用空间，空间复杂度O(1)。
 *          不稳定算法，不会交换两个相同元素的相对位置
 *插入排序：最坏情况——比较次数1+2+3+...+(n-1)=n*(n-1)/2,每次都要狡交换，最坏的时间复杂度是O(N^2)；
 *         最好情况——比较n-1次，无需进行交换，最好的时间复杂度是O(N)；
 *         平均情况——实际上平均每次只会有一般已排序的元素进行比较。所以平均比较n*(n-1)/4次，平均交换n*(n-1)/4次；
 *         只有临时变量temp占用空间，空间复杂度O(1)。
 *         稳定算法，不会交换两个相同元素的相对位置。
 *
 *  上述三种算法比较：冒泡排序交换次数过多，一般不使用，除非数据量很小；
 *                  选择排序虽然降低了交换次数，当比较次数高；
 *                  插入排序在一定程度上降低了比较次数和交换次数，特别实在数据已经基本有序的情况下。
 *
 *
 * @author: ex_lihui4
 * @date: 2020-3-25  15:00
 *
 */

public class Sort {
    /**
     * 插入排序：讲数组分为已排序和未排序两部分。每次从未排序拿出一个元素，插入已排序的合适位置
     *  稳定排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[++j] = temp;
        }
    }

    /**
     * 冒泡排序：相邻两个数进行比较，大数往后，经过第一轮(n-1次）比较，最大的数据在最后；第二轮（n-2）,第二大的数在倒数第二；
     * 第n-1轮（1次）比较，完成比较。
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp;
        int length = arr.length;
        for (int i = length-1; i >=0; i--) {
            boolean flag=false;
            for (int j=0;j<i;j++){
                 if (arr[j+1]<arr[j]){
                     temp=arr[j];
                     arr[j]=arr[j+1];
                     arr[j+1]=temp;
                     flag=true;
                 }
             }
            if (!flag) break;
        }
    }

    /**
     * 选择排序：讲数组分为已排序和未排序两部分，每次从未排序中选出最小的放在已排序的末尾
     * @param arr
     */
    public static void selectionSort(int[] arr) {

        int length = arr.length;
        for (int i = 0; i <length-1; i++) {
            int minIndex=i;
            for (int j=i+1;j<length;j++){
                if (arr[minIndex]>arr[j]){
                   minIndex=j;
                }
            }
            if (minIndex!=i){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random random=new Random();
        for (int i=0;i<arr.length;i++){
            arr[i]= random.nextInt(100000);
        }
        int[] int1 = Arrays.copyOf(arr, 100000);
        int[] int2 = Arrays.copyOf(arr, 100000);
        long l = System.currentTimeMillis();
        Sort.selectionSort(arr);
        long b = System.currentTimeMillis();
        System.out.println("选择排序："+(b-l));
        long l1 = System.currentTimeMillis();
        Sort.bubbleSort(int1);
        long b1 = System.currentTimeMillis();
        System.out.println("冒泡排序："+(b1-l1));
        long l2 = System.currentTimeMillis();
        Sort.insertSort(int2);
        long b2 = System.currentTimeMillis();
        System.out.println("插入排序："+(b2-l2));
    }
}
