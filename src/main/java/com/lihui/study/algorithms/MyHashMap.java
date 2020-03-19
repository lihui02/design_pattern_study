package com.lihui.study.algorithms;

import java.util.LinkedList;

/**
 * @ClassName: MyHashMap
 * @Description: 自定义的HashMap
 * @author: ex_lihui4
 * @date: 2020-3-9  9:23
 */

public class MyHashMap<K,V> {
    private int tableSize=16;
    private LinkedList[] arr;
    public MyHashMap() {
        arr=new LinkedList[tableSize];
    }

    public MyHashMap(int currentSize) {
        arr=new LinkedList[currentSize];
        this.tableSize = currentSize;
    }

    private int myHash(K k){
        return k.hashCode() % tableSize;
    }

    public boolean insert(K k,V v){
        LinkedList<V> list=arr[myHash(k)];
        if (list==null){
            LinkedList<V> list1 = new LinkedList<>();
            list1.add(v);
            arr[myHash(k)]=list1;
        }else if (!list.contains(v)){
            //解决冲突
            list.add(v);

        }else {
            return false;
        }
        //其实这里还涉及到扩容问题  在散列
        return true;
    }

    public void remove(K k){
        LinkedList<V> list=arr[myHash(k)];
        if (list==null){
            return;
        }
        arr[myHash(k)]=null;
    }
    public void remove(K k,V v){
        LinkedList<V> list=arr[myHash(k)];
        if (list==null){
            return;
        }
        System.out.println(1111);
        list.remove(v);
    }

}
