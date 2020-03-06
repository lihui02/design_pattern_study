package com.lihui.study.algorithms;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @ClassName: MyArrayList
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-3-5  17:26
 */

public class MyArrayList<E> implements Iterable<E> {
    private int size = 0;
    private Object[] arr;

    public MyArrayList(int initialCapacity) {
        arr = new Object[initialCapacity];
    }

    public MyArrayList() {
        arr = new Object[16];
    }

    public E get(int i){
      return (E)arr[i];
    }
    public void add(E e){
        arr[size]=e;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator();
    }

    private class Iterator<E> implements java.util.Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current != size;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }
}
