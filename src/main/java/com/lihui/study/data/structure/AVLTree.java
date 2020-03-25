package com.lihui.study.data.structure;

import java.util.TreeSet;

/**
 * @ClassName: AVLTree
 * @Description: AVL 二叉树
 * @author: ex_lihui4
 * @date: 2020-3-6  11:11
 */

public class
AVLTree<E extends Comparable<? super E>> {
    private AVLNode<E> root;

    private static class AVLNode<E> {
        private E element;
        private AVLNode<E> left;
        private AVLNode<E> right;
        private int height;

        public AVLNode(E element, AVLNode left, AVLNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

        public AVLNode(E element) {
            this(element, null, null);
        }
    }

    /**
     * 返回树的高度
     *
     * @param avlNode
     * @return
     */
    private int getHeight(AVLNode avlNode) {
        return avlNode == null ? -1 : avlNode.height;
    }


    /**
     * 插入元素
     *
     * @param e
     */
    public void insert(E e) {
        root = insert(e, root);
    }

    /**
     * 插入元素
     *
     * @param e
     * @param avlNode
     * @return
     */
    private AVLNode<E> insert(E e, AVLNode<E> avlNode) {
        if (avlNode == null) {
            return new AVLNode<>(e, null, null);
        }
        int result = e.compareTo(avlNode.element);
        if (result==0) return avlNode;
        if (result < 0) {
            avlNode.left = insert(e, avlNode.left);

        } else if (result > 0) {
            avlNode.right = insert(e, avlNode.right);
        }
        avlNode.height = Math.max(getHeight(avlNode.left), getHeight(avlNode.right)) + 1;
        return balance(avlNode);
    }

    /**
     * 对插入后的树进行平衡
     *
     * @param avlNode
     * @return
     */
    private static final int ALLOWED_IMBALANCE = 1;//设置平衡阈值

    private AVLNode<E> balance(AVLNode<E> avlNode) {
        if (avlNode == null) return null;
        if (getHeight(avlNode.left) - getHeight(avlNode.right) > ALLOWED_IMBALANCE) {
            //第一种边界情况，左儿子的左树长了
            if (getHeight(avlNode.left.left) > getHeight(avlNode.left.right)) {
                avlNode = rotateWithLeftChild(avlNode);

            }
            //第二种边界情况，左儿子的右树长了
            if (getHeight(avlNode.left.left) < getHeight(avlNode.left.right)) {
                avlNode = doubleRotateWithLeftRightChild(avlNode);
            }
        } else if (getHeight(avlNode.right) - getHeight(avlNode.left) > ALLOWED_IMBALANCE) {

            if (getHeight(avlNode.left) - getHeight(avlNode.right) > ALLOWED_IMBALANCE) {
                //第三种边界情况，右儿子的左树长了
                if (getHeight(avlNode.right.left) > getHeight(avlNode.right.right)) {
                    avlNode = doubleRotateWithRightLeftChild(avlNode);
                }
                //第四种边界情况，右儿子的右树长了
                if (getHeight(avlNode.right.left) < getHeight(avlNode.right.right)) {
                    avlNode = rotateWithRightChild(avlNode);
                }
            }
        }else {
            //不需要平衡
        }
        return avlNode;
    }

    /**
     * 左-左树单旋转
     *
     * @param k2
     * @return
     */
    private AVLNode<E> rotateWithLeftChild(AVLNode<E> k2) {
        AVLNode<E> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(getHeight(k2.left), getHeight(k2.right)) + 1;
        k1.height = Math.max(getHeight(k1.left), getHeight(k1.right)) + 1;
        return k1;
    }

    /**
     * 左-右树双旋转
     *
     * @param k3
     * @return
     */
    private AVLNode<E> doubleRotateWithLeftRightChild(AVLNode<E> k3) {
      k3.left=rotateWithRightChild(k3.left);
      return rotateWithLeftChild(k3);
    }

    /**
     * 右-右树单旋转
     *
     * @param k2
     * @return
     */
    private AVLNode<E> rotateWithRightChild(AVLNode<E> k2) {
        AVLNode<E> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(getHeight(k2.left), getHeight(k2.right)) + 1;
        k1.height = Math.max(getHeight(k1.left), getHeight(k1.right)) + 1;
        return k1;
    }

    /**
     * 右-左树双旋转
     *
     * @param k1
     * @return
     */
    private AVLNode<E> doubleRotateWithRightLeftChild(AVLNode<E> k1) {
        k1.right=rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private void print(AVLNode node,String a){
        a=a+a;
        if (node==null) return;
        print(node.left,a);
        System.out.println(a+""+node.element);
        print(node.right,a);
    }
    public void print(){
        print(this.root,"-");
    }
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
         tree.insert(7);
         tree.insert(4);
         tree.
                 insert(10);
         tree.insert(3);
         tree.insert(5);
         tree.insert(6);
         tree.print();
        TreeSet set=new TreeSet();


    }


}


