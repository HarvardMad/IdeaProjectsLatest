import scala.collection.JavaConverters._

/**
 * Created by LalinPethiyagoda on 02/06/2016.
 * list.init gets all but last
 * list. last gets last
 */
object ReverseList extends App{
  val aList = List(1,2,3,5,6,6,8)

  def revlist(ls:List[Int]):Unit={
    def revHelper(lsOne:List[Int], result:List[Int]):List[Int]=lsOne match{
      case Nil => result
      case head::tail=> {
        revHelper(head::result, tail)
      }
    }
    println(revHelper(ls,Nil))
  }

  revlist(aList)

}
