package com.longxw.tree;

public class TreeNode<T> {

    T t;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(T t){
        this.t = t;
    }

    public static void main(String[] args) {
        TreeNode<String> treeNode = new TreeNode("1");
        treeNode.setLeft(new TreeNode("2"));
        treeNode.setRight(new TreeNode("3"));
    }
}
