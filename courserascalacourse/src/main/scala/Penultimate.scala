/**
 * Created by LalinPethiyagoda on 02/06/2016.
 * dont forget that Scala Lists behave as java Linked Lists
 */
object Penultimate extends App {
  val aList = List(1,2,3,5,6,6,7,9,8)

  def penult(ls:List[Int]):Int=ls match{

    case head::Nil=>head
    case head::tail =>{
      if(tail.length==1)
        head
      else
        penult(tail)
    }
  }

  println(penult(aList))
}
