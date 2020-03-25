package com.lihui.study.data.structure;

import java.util.ArrayList;

/**
 * @param <T>
 *     最小堆的实现
 */
public class BinaryHeap<T extends Comparable< ? super T>> {
    private ArrayList<T> list;
    private int currentSize;

    public BinaryHeap() {
       list=new ArrayList<>();
    }

    /**
     * 上滤，插入
     * @param t
     */
    public void insert(T t){

        //插入下一个空的位置
        int index=list.size();
        list.add(t);
        //比较大小，交换位置
        while (index>0&&list.get(index).compareTo(list.get((index-1)/2))<0){
            T temp=list.get((index-1)/2);
            list.set((index-1)/2,t);
            list.set(index,temp);
            index=(index-1)/2;
        }
    }

    /**
     * 下滤实现删除，将最后一个元素放到首位，在进行下滤
     * @return
     */
    public T deleteMin(){
        T t=list.get(0);
        int index=0;
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);
        //下滤
        while (index*2+1<=list.size()-1){
            int index1=index*2+1;
            int index2=index*2+2;
            //只有一个左节点
            if (index1==list.size()-1){
                swap(index,index1);
                break;
            }else {
                //左节点小
                if (list.get(index1).compareTo(list.get(index2))<0){
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
        if (list.get(index1).compareTo(list.get(index2))>0){
         T temp=list.get(index1);
         list.set(index1,list.get(index2));
         list.set(index2,temp);
        }
    }

    /**
     * 数组构建最小二叉堆   下沉（注意：插入是上浮）利用insert的时间复杂度是O(NlogN)
     * 而上浮发是O(N)
     * * @param arr
     */
    public BinaryHeap(T[] arr){
        int n=arr.length;
        list=new ArrayList<>();
        for (T t:arr){
            list.add(t);
        }
        //从最后一个非叶子节点开始操作
        for (int i=list.size()/2-1;i>=0;i--){
            int index=i;
            int index1=index*2+1;
            int index2=index*2+2;
            while (index1<=list.size()){

                //只有一个左节点
                if (index1==list.size()-1){
                    swap(index,index1);
                    index=index1;
                }else {
                    //左节点小
                    if (list.get(index1).compareTo(list.get(index2))<0){
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

    }
    public static void main(String[] args) {
        Integer[] a=new Integer[]{19,7,4,8,19,12};
        BinaryHeap<Integer> heap=new BinaryHeap<>(a);
        System.out.println(heap.list);


    }
}
