package com.lihui.study.algorithms;

/**
 * @ClassName: AVLTree
 * @Description: AVL 二叉树
 * @author: ex_lihui4
 * @date: 2020-3-6  11:11
 */

public class AVLTree<E extends Comparable<? super E>> {
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
        if (result < 0) {
            avlNode.left = insert(e, avlNode.left);

        } else if (result > 0) {
            avlNode.right = insert(e, avlNode.right);
        }
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

            }
        } else if (getHeight(avlNode.right) - getHeight(avlNode.left) > ALLOWED_IMBALANCE) {

            if (getHeight(avlNode.left) - getHeight(avlNode.right) > ALLOWED_IMBALANCE) {
                //第三种边界情况，右儿子的左树长了
                if (getHeight(avlNode.right.left) > getHeight(avlNode.right.right)) {

                }
                //第四种边界情况，右儿子的右树长了
                if (getHeight(avlNode.right.left) < getHeight(avlNode.right.right)) {
                    avlNode = rotateWithRightChild(avlNode);
                }

            }
        }
        return avlNode;
    }

    /**
     * 左树单旋转
     * @param k2
     * @return
     */
    private AVLNode<E> rotateWithLeftChild(AVLNode<E> k2) {
        AVLNode<E> k1 = k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=Math.max(getHeight(k2.left),getHeight(k2.right))+1;
        k1.height=Math.max(getHeight(k1.left),getHeight(k1.right))+1;
        return k1;
    }
    /**
     * 右树单旋转
     * @param k2
     * @return
     */
    private AVLNode<E> rotateWithRightChild(AVLNode<E> k2) {
        AVLNode<E> k1 = k2.right;
        k2.right=k1.left;
        k1.left=k2;
        k2.height=Math.max(getHeight(k2.left),getHeight(k2.right))+1;
        k1.height=Math.max(getHeight(k1.left),getHeight(k1.right))+1;
        return k1;
    }

    public static void main(String[] args) {


    }


}


