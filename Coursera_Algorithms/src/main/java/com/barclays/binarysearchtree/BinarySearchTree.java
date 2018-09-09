package com.barclays.binarysearchtree;

public class BinarySearchTree {
  private TreeNode root=null;

  public BinarySearchTree(TreeNode root){
    this.root = root;
  }


  public TreeNode addNode(int data){
    return addNodeRecursive(root, data);
  }

  public void inOrderTraversal(){
    inOrderTraversalRecursive(root);
  }

  private void inOrderTraversalRecursive(TreeNode node){

    if(node == null){
      return;
    }
    else {
      inOrderTraversalRecursive(node.getLeft());
      System.out.print(node.getData() + " ");
      inOrderTraversalRecursive(node.getRight());
    }
  }

private TreeNode addNodeRecursive(TreeNode currentNode , int data){

    if(currentNode == null){
      root = new TreeNode(data);
    }
    if(currentNode.getData()> data){ // you are smaller than the current node - smaller go left
      if(currentNode.getLeft()==null){
        TreeNode newTN = new TreeNode(data);
        currentNode.setLeft(newTN);
      }else{
        addNodeRecursive(currentNode.getLeft(), data);
      }
    }
    else if (currentNode.getData()< data){ // you are bigger than the current node - bigger go right
      if(currentNode.getRight()==null){
        TreeNode newTN = new TreeNode(data);
        currentNode.setRight(newTN);
      }
      else{
        addNodeRecursive(currentNode.getRight(),data);
      }
    }
  return currentNode;
}

  public static void main(String[] args) {

    BinarySearchTree bst = new BinarySearchTree(new TreeNode(10));
    bst.addNode(6);
    bst.addNode(4);
    bst.addNode(7);
    bst.addNode(8);
    bst.addNode(9);
    bst.addNode(3);
    bst.addNode(1);
    bst.addNode(2);
    bst.addNode(5);
    bst.addNode(20);

    bst.addNode(15);
    bst.addNode(12);
    bst.addNode(13);
    bst.addNode(14);
    bst.addNode(11);
    bst.addNode(17);
    bst.addNode(18);
    bst.addNode(19);
    bst.addNode(16);

    bst.inOrderTraversal();
  }

}
