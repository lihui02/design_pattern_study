package com.lihui.study.algorithms;

/**
 * @ClassName: MyBinomialQueue
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-3-20  22:13
 */

public class MyBinomialQueue<T extends Comparable<? super T>> {
    private BinNode<T>[] nodes;

    public MyBinomialQueue() {
        nodes=new BinNode[1];
    }
    public void insert(T element){

    }

    private static class BinNode<T>{
        private T element;
        private BinNode<T> leftChild;
        private BinNode<T> nextSibling;


        public BinNode(T element) {
           this(element,null,null);
        }

        public BinNode(T element, BinNode<T> leftChild, BinNode<T> nextSibling) {
            this.element = element;
            this.leftChild = leftChild;
            this.nextSibling = nextSibling;
        }
    }
}
