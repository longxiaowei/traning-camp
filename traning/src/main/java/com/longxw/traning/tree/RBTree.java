package com.longxw.traning.tree;

import java.util.HashMap;

/**
 * 红黑树
 * @author longxw
 * @since 2020/3/9
 */
public class RBTree {

    static final class TreeNode<K, V>{
        TreeNode<K,V> parent;  // red-black tree links
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        boolean red;


        /**
         * 左旋 将节点 P 进行左旋
         * 设 节点P的右孩子为 y， 左孩子为 a
         * 设 节点Y的左孩子为b，右孩子为c
         * 将 p节点左旋步骤如下：
         * 1. 将 y的左孩子 b设置为 p的右孩子
         * 2. 将 p节点设置 y的左孩子的父亲
         * 3. 将 x的父亲设置为y的父亲
         * 4. 将 x设置为 y的左孩子
         * @since 2020/3/9
         * @param root
         * @param p
         * @return com.longxw.traning.tree.RBTree.TreeNode<K, V>
         */
        static <K,V> TreeNode<K,V> rotateLeft(TreeNode<K,V> root, TreeNode<K,V> p) {

            // 1. 设置 pRightNode 为 p节点的右孩子
            TreeNode<K, V> pRightNode = p.right;

            // 2. 将 pRightNode 的左孩子 设置为 p节点的右孩子
            p.right = pRightNode.left;

            // 3. 将 pRightNode 的左孩子的父亲设置为 P节点
            pRightNode.parent = p;


            // 4. 将p节点的父亲设置为 pRightNode 的父亲。

            pRightNode.parent = p.parent;

            // 5. 如果 p为左孩子， 则设置pRightNode为 p节点的父亲的左孩子， 反之则设置

            return root;
        }

        /**
         * 右旋
         * @since 2020/3/9
         * @param root
         * @param p
         * @return com.longxw.traning.tree.RBTree.TreeNode<K, V>
         */
        static <K,V> TreeNode<K,V> rotateRight(TreeNode<K,V> root, TreeNode<K,V> p) {
            return root;
        }

    }
}
