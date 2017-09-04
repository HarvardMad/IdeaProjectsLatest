package nintynine.scala.tasks

object ReverseListUsingFold extends App {
 val xs = List(1, 1, 2, 10, 5, 8)
  def reverse(xs:List[Int]):List[Int]={
	 xs.foldLeft(List[Int]())((resultList:List[Int],xsListItem)=>xsListItem::resultList)
 }
 
 println(reverse(xs))
}