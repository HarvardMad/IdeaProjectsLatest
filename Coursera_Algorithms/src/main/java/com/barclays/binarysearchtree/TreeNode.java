package com.barclays.binarysearchtree;

public class TreeNode {

  private int data = 0;
  private TreeNode left;
  private TreeNode right;

  public TreeNode(int data) {
    this.data = data;
    left = null;
    right = null;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
