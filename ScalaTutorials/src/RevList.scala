/**
 * Created by LalinPethiyagoda on 05/12/2015.
 */
object RevList extends App{
  val x=List(1,2,3,4,5)
  val y =List()

  def revList(x:List[Int]):List[Int]={
    def revListHelper(x:List[Int],y:List[Int]): List[Int] = x match{
      case Nil=>y
      case x::tail=>revListHelper(tail,x::y)
    }
    revListHelper(x,y)
  }
  println(revList(x))
}
