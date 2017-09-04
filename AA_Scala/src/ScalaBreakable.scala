/**
 * Created by LalinPethiyagoda on 30/01/2016.
 */

import scala.util.control.Breaks._
object ScalaBreakable extends App{

    breakable{
      for(i<- 0 until "lalin is fine he is fun".length) {
        println(i)
        var x = i
        if (x==5) break
      }
    }
}
