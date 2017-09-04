/**
 * Created by LalinPethiyagoda on 06/12/2015.
 */
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object BubbleSort extends App {
  var x = Array(2, 1, 5, 4, 8)
  def bsort(xList:Array[Int]): Array[Int]= {
    var temp: Int = 0
    for (a <- 0 until xList.size) {
      for (b <- 0 until xList.size - 1) {
        if (xList(b) > xList(b + 1)) {
          temp = xList(b)
          xList(b)= xList(b + 1)
          xList(b + 1) =temp
        }
      }
    }
    xList
  }
  println(bsort(x).toList)
}
