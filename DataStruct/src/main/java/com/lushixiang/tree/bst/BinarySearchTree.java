package com.lushixiang.tree.bst;

import java.nio.file.attribute.UserPrincipalLookupService;

public class BinarySearchTree<T extends Comparable<T>> {

    private BSTNode<T> root;

    /**
     * use to describe BST tree node
     * the node is comparable by node value
     * @param <T>
     */
    public class BSTNode<T extends Comparable<T>>{

        T key;
        BSTNode<T> parent;
        BSTNode<T> left;
        BSTNode<T> right;

        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    // 遍历
    public void visitByPre(BSTNode<T> root){
        if(root == null){
            return;
        }
        System.out.println(root.key);
        visitByPre(root.left);
        visitByPre(root.left);
    }

    // 查找特定值-类似与二分查找
    public boolean seekValue(BSTNode<T> root, T value){
        if(root == null){
            return false;
        }
        if(root.key == value){
            return true;
        }
        if(root.key.compareTo(value)>0 ){
            return seekValue(root.left, value);
        }
        return seekValue(root.right, value);
    }

    // 查找，非迭代版本
    public boolean seekValueWithout(BSTNode<T> root, T value){
        while(root != null){
            if(root.key.compareTo(value) == 0){
                return true;
            }
            if(root.key.compareTo(value) > 0){
                root = root.left;
            }
            root = root.right;
        }
        return false;
    }

    // 查找直接前驱或直接后驱 = 查找该节点的
}
