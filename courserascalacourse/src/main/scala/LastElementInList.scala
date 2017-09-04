/**
 * Created by LalinPethiyagoda on 02/06/2016.
 * uses tail recursion and pattern matching
 */
object LastElementInList extends App{

  val aList = List(1,2,3,5,6,6,8)
def findLastElem(ls:List[Int]):Int=ls match{

  case head::Nil => head
  case head::tail=>findLastElem(tail)
  case _ => throw new NoSuchElementException
}

  //run
  println(findLastElem(aList))
}
