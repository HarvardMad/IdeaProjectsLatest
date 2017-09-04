/**
 * Created by LalinPethiyagoda on 05/12/2015.
 */
object ProductOfAList extends App {
val x = List( 1,2,3,4,5)
  def productList(x:List[Int]):Int={
    def productListHelper(x:List[Int],acc:Int): Int =  x match{
      case Nil=>acc
      case y::tail=>productListHelper(tail,y*acc) //consume the list:

    }
    productListHelper(x,1)
  }
  println(productList(x))
}
