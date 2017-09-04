/**
 * Created by LalinPethiyagoda on 02/06/2016.
 */
object ElementCounter extends App{
  val aList = List(1,2,3,5,6,6,8)

  def elemCount(ls:List[Int]):Unit={
  def countHelper(acc:Int, ls:List[Int]):Int=ls match{
    case Nil => acc
    case head::Nil => acc+1
    case head::tail => countHelper(acc+1,tail)
    case _=> throw new NoSuchElementException
  }
   println(countHelper(0,aList))
  }

  elemCount(aList)
}
