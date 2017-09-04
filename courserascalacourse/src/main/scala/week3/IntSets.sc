object intSets extends App {
val  treeOne=new NonEmpty(3, new Empty, new Empty)
val treeTwo = treeOne.incl(4)
}
/*
Implementing sets as binary trees
there are two variants:


 */
abstract class IntSet{
  def incl(x:Int):IntSet
  def contains(x:Int):Boolean // checks if a value exists in a node
  def union(other:IntSet):IntSet // union of the set you are on and the "other" set
}
class NonEmpty(currentElement: Int, leftSubTree:IntSet, rightSubTree:IntSet) extends IntSet{

  override def union(other:IntSet):IntSet={
    (leftSubTree.union(rightSubTree)).union(other).incl(currentElement)
  }

  override def contains(x:Int):Boolean={
    if(x<currentElement){
      // search the left subtree, if x is less than the current node's value
      leftSubTree.contains(x)
    }
    else if(x>currentElement){
      //if x is greater than the current Element visited then traverse right sub tree
      rightSubTree.contains(x)
    }
    else true
  }
  //adding an elemnt to the tree
  /*
  if the valuse is less than the value in the current node
  then we have ti add a NON EMPTY node to the correct position in the left sub tree.
  this would mean, potentially, visiting each node down the relevant sub tree and
  each time it hits a non empty node,
  a check would have to be made to see if the value in the node is greater or less than equal to the vlaue
  you wish to enter.

   */
  override def incl(x:Int):IntSet={
    if(x<currentElement){
      new NonEmpty(currentElement,leftSubTree.incl(x), rightSubTree)
    }
    else if (x>currentElement){
      new NonEmpty(currentElement, leftSubTree,rightSubTree.incl(x))
    }
    else this
  }


}
class Empty extends IntSet{
  override def contains(x:Int):Boolean=false
  override def incl(x:Int):IntSet={
    new NonEmpty(x, new Empty,new Empty)
  }
  override def union(other:IntSet):IntSet=other
}

