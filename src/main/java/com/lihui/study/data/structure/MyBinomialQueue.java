package com.lihui.study.data.structure;


/**
 * @ClassName: MyBinomialQueue
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-3-20  22:13
 */

public class MyBinomialQueue<T extends Comparable<? super T>> {
    private BinNode<T>[] nodes;

    private int currentSize = 0;

    public MyBinomialQueue() {
        nodes = new BinNode[1];

    }

    public MyBinomialQueue(T t) {
        nodes = new BinNode[1];
        nodes[0] = new BinNode<>(t, null, null);
        currentSize = 1;
    }

    /**
     * 合并
     *
     * @param queue
     */
    public void merge(MyBinomialQueue<T> queue) {
        if (this == queue) return;
        currentSize += queue.currentSize;
        //15个元素最多需要1+2+4+8，也就是4个位置
        if (currentSize > capacity()) {
            //扩容
            //新旧数组，大的那一个加1
            int newLength = Math.max(this.nodes.length, queue.nodes.length) + 1;
            expandCapatity(newLength);
        }
        //合并
        BinNode<T> carry = null;   //进位
        for (int i = 0, j = 1; j <= currentSize; i++, j *= 2) {
            BinNode<T> t1 = this.nodes[i];
            BinNode<T> t2 = i<queue.nodes.length?queue.nodes[i]:null;
            int whichCase = t1 == null ? 0 : 1;
            whichCase += t2 == null ? 0 : 2;
            whichCase += carry == null ? 0 : 4;
            switch (whichCase) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    this.nodes[i] = t2;
                    queue.nodes[i] = null;
                    break;
                case 3:
                    carry = combineTrees(t1, t2);
                    this.nodes[i] = queue.nodes[i] = null;
                    break;
                case 4:
                    this.nodes[i] = carry;
                    carry = null;
                    break;
                case 5:
                    carry = combineTrees(t1, carry);
                    this.nodes[i] = null;
                    break;
                case 6:
                    carry = combineTrees(t2, carry);
                    queue.nodes[i] = null;
                    break;
                case 7:
                    this.nodes[i] = carry;
                    carry = combineTrees(t1, t2);
                    queue.nodes[i] = null;
                    this.nodes[i] = null;
                    break;
            }
        }
    }


    /**
     * 合并两颗数
     *
     * @param t1
     * @param t2
     * @return
     */
    private BinNode<T> combineTrees(BinNode<T> t1, BinNode<T> t2) {
        if (t1.element.compareTo(t2.element) > 0) return combineTrees(t2, t1);
        t2.nextSibling = t1.leftChild;
        t1.leftChild = t2;
        return t1;
    }

    /**
     * 根据数组的长度确定当装满的情况下，最少可以装多少元素。比如数组
     * 长度为4，最少可以装1+2+4+8=15个。
     *
     * @return
     */
    private int capacity() {
        return (1 << nodes.length) - 1;
    }

    private void expandCapatity(int newLength) {
        BinNode<T>[] oldNodes = nodes;
        int oldLength = oldNodes.length;
        nodes = new BinNode[newLength];
        for (int i = 0; i < oldLength; i++)
            nodes[i] = oldNodes[i];
        for (int i = oldLength; i < newLength; i++)
            nodes[i] = null;
    }

    /**
     * 插入一个元素
     *
     * @param element
     */
    public void insert(T element) {
        this.merge(new MyBinomialQueue(element));
    }

    /**
     * 删除最小值
     *
     * @return
     */
    public T deleteMin() {
        int minIndex = findMinIndex();
        T result = nodes[minIndex].element;
        BinNode t1 = nodes[minIndex].leftChild;
        MyBinomialQueue queue = new MyBinomialQueue();
        queue.expandCapatity(minIndex);
        for (int i = minIndex - 1; i >= 0; i--) {
            queue.nodes[i] = t1;
            t1 = t1.nextSibling;
            queue.nodes[i].nextSibling = null;
        }
        this.nodes[minIndex] = null;
        this.merge(queue);
        return result;
    }

    public T findMin() {
        int minIndex = findMinIndex();
        return nodes[minIndex].element;
    }

    private int findMinIndex() {
        int i;
        int minIndex;
        for (i = 0; nodes[i] == null; i++) ;
        for (minIndex = i; i < nodes.length; i++) {
            if (nodes[i] != null && nodes[i].element.compareTo(nodes[minIndex].element) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static class BinNode<T> {
        private T element;
        private BinNode<T> leftChild;
        private BinNode<T> nextSibling;


        BinNode(T element) {
            this(element, null, null);
        }

        BinNode(T element, BinNode<T> leftChild, BinNode<T> nextSibling) {
            this.element = element;
            this.leftChild = leftChild;
            this.nextSibling = nextSibling;
        }
    }


    public static void main(String[] args) {
        MyBinomialQueue queue = new MyBinomialQueue();
        queue.insert(10);
        queue.insert(5);
        queue.insert(3);
        queue.insert(7);
        queue.insert(9);
        MyBinomialQueue queue1 = new MyBinomialQueue();
        queue1.insert(13);
        queue1.insert(4);
        queue.merge(queue1);

    }
}
