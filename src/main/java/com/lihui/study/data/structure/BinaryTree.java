package com.lihui.study.data.structure;

/**
 * @ClassName: BinaryTree
 * @Description: 自定义二叉树
 * @author: ex_lihui4
 * @date: 2020-3-6  11:11
 */

public class BinaryTree<E extends Comparable<? super E> > {
    private BinaryNode<E> root;

    private class BinaryNode<E> {
        private E element;
        private BinaryNode left;
        private BinaryNode right;

        public BinaryNode(E element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public BinaryNode(E element) {
            this(element,null,null);
        }
    }
    /**
     * 是否包含某个元素
     */

    public boolean contains(E e){
        return contains(e,root);
    }
    /**
     * 数是否包含某个元素
     * @param e
     * @param binaryNode
     * @return
     */
    private boolean contains(E e,BinaryNode<E> binaryNode){
        if (binaryNode==null) return false;
        int result = e.compareTo(binaryNode.element);
        if (result<0) {
            return contains(e,binaryNode.left);
        }else if (result>0){
            return contains(e,binaryNode.right);
        }else {
            return true;
        }
    }

    /**
     * 使用递归求树的最小节点
     * @param binaryNode
     * @return
     */
    public BinaryNode<E> findMin(BinaryNode<E> binaryNode){
        if (binaryNode==null) return null;
        if (binaryNode.left==null) {
            return binaryNode;
        } else {
            return findMin(binaryNode.left);
        }
    }
    /**
     * 使用非递归求树的最大节点
     * @param binaryNode
     * @return
     */
    public BinaryNode<E> findMax(BinaryNode<E> binaryNode){
       while (binaryNode.right!=null){
           binaryNode=binaryNode.right;
       }
       return binaryNode;
    }

    /**
     * 插入元素
     * @param e
     */
    public void insert(E e){
        root=insert(e,root);
    }
    /**
     * 插入元素
     * @param e
     * @param binaryNode
     * @return
     */
    private BinaryNode<E> insert(E e,BinaryNode<E> binaryNode){
        if (e==null) throw new RuntimeException("不能插入null");
        if (binaryNode==null){
            return new BinaryNode<>(e,null,null);
        }
        int result = e.compareTo(binaryNode.element);
        if (result<0){
            binaryNode.left= insert(e,binaryNode.left);
        }else if (result>0){
            binaryNode.right= insert(e,binaryNode.right);
        }
        return binaryNode;
    }
    /**
     * 删除元素
     */
    public void remove(E e){
        root=remove(e,root);
    }
    /**
     * 删除一个节点，叶子节点没有直接删除；只有一个节点，直接代替原节点；有两个节点，用有节点的最左节点代替。
     *
     */
     private BinaryNode<E> remove(E e,BinaryNode<E> binaryNode){
         if (binaryNode==null){
             return binaryNode;
         }
         int result = e.compareTo(binaryNode.element);
         if (result<0){
             binaryNode.left=remove(e,binaryNode.left);
         }else if (result>0){
             binaryNode.right=remove(e,binaryNode.right);
         }else if (result==0&&binaryNode.left!=null && binaryNode.right!=null){
             //有两个节点,该节点用右数的最小值代替
             binaryNode.element = (E)findMin(binaryNode.right).element;
             //删除移动的元素
             binaryNode.right = remove(binaryNode.element, binaryNode.right);
         }else if (result==0){
             //一个或者0个节点
             binaryNode=binaryNode.left!=null?binaryNode.left:binaryNode.right;
         }
         return binaryNode;
     }

    public BinaryNode print(BinaryNode node) {
        if (node.right!=null) {
            System.out.println("-") ;
            return node.right;
        } else {
            System.out.println(node);
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree=new BinaryTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(6);
        tree.insert(12);
        tree.insert(10);
        tree.insert(13);
        //遍历


    }

}
