/**
 * Created by LalinPethiyagoda on 30/01/2016.
 */

import scala.util.control.Breaks._
object BreakAndContinue extends App{
  val str = "peter pepper picked a peck of pickled peppers"
  var pCount =0
  for(i<-0 to str.length-1){

  breakable{
      if(str.charAt(i)=='p'){
        pCount+=1
      }else break // break out of breakable
    }
  }
  println(pCount + " instances of p s")
}
