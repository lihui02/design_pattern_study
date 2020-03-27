package com.lihui.study.data.structure;

import java.util.Arrays;

/**
 * @param <T>
 *     最小堆的实现 基于array
 */
public class ArrayBinaryHeap<T extends Comparable< ? super T>> {
    private Object[] arr;
    private int currentSize;

    public ArrayBinaryHeap() {
      arr=new Object[0];
    }

    public Object[] getArr() {
        return arr;
    }

    public void setArr(Object[] arr) {
        this.arr = arr;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    /**
     * 上滤，插入
     * @param t
     */
    public void insert(T t){

        //插入下一个空的位置
        int index=currentSize;
        //是否需要扩容
        if (index>arr.length-1){
            Object[] newArr=new Object[index+index/2];
           System.arraycopy(arr,0,newArr,0,arr.length);
           arr=newArr;
        }
        arr[index]=t;
        //比较大小，交换位置
        T t1=(T)arr[index];
        T t2=(T)arr[(index-1)/2];
        while (index>0&&t1.compareTo(t2)<0){
            T temp=t2;
            arr[(index-1)/2]=t1;
            arr[index]=temp;
            index=(index-1)/2;
        }
        currentSize++;
    }

    /**
     * 下滤实现删除，将最后一个元素放到首位，在进行下滤
     * @return
     */
    public T deleteMin(){
        T t=(T)arr[0];
        int index=0;
        arr[0]=arr[currentSize-1];
        arr[currentSize-1]=null;
        currentSize--;
        //下滤
        while (index*2+1<=currentSize-1){
            int index1=index*2+1;
            int index2=index*2+2;
            //只有一个左节点
            if (index1==currentSize-1){
                swap(index,index1);
                break;
            }else {
                //左节点小

                if (((T)arr[index1]).compareTo(((T)arr[index2]))<0){
                    swap(index,index1);
                    index=index*2+1;
                }else {
                    //右节点小
                    swap(index,index2);
                    index=index*2+2;
                }
            }

        }
        return t;
    }
    // 比较，若果满足list.index1>list.index2,则进行交换
    private void swap(int index1,int index2){
        if (((T)arr[index1]).compareTo(((T)arr[index2]))>0){
         T temp=(T)arr[index1];
         arr[index1]=arr[index2];
         arr[index2]=temp;
        }
    }

    /**
     * 数组构建最小二叉堆   下沉（注意：插入是上浮）利用insert的时间复杂度是O(NlogN)
     * 而上浮构建的时间复杂度是O(N)
     * * @param arr
     */
    public void buildBinaryHeap(T[] arr1){
        int length=arr1.length;
        this.arr=arr1;

        //从最后一个非叶子节点开始操作
        for (int i=length/2-1;i>=0;i--){
            int index=i;
            int index1=index*2+1;
            int index2=index*2+2;
            while (index1<=length){

                //只有一个左节点
                if (index1==length-1){
                    swap(index,index1);
                    index=index1;
                }else {
                    //左节点小
                    if (((T)arr[index1]).compareTo((T)arr[index2])<0){
                        swap(index,index1);
                        index=index1;
                    }else {
                        //右节点小
                        swap(index,index2);
                        index=index2;
                    }
                }
                index1=index*2+1;
                index2=index*2+2;
            }
        }
        currentSize=length;

    }
    public static void main(String[] args) {
        Integer[] a=new Integer[]{19,7,4,8,19,12};
        ArrayBinaryHeap<Integer> heap=new ArrayBinaryHeap<>();
        heap.buildBinaryHeap(a);
        heap.insert(3);
        System.out.println(Arrays.toString(heap.arr));


    }
}
