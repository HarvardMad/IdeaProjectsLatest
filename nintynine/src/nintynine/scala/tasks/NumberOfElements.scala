package nintynine.scala.tasks

object NumberOfElements extends App{
  
   val xs = List(1, 1, 2, 10, 5, 8)
   
   def listLength(xs:List[Int]):Int={
	   def itemCounter(xs:List[Int], acc:Int):Int=xs match{
	      case List() => acc
	      case y::ys => itemCounter(ys,acc+1)     
	   }
	   itemCounter(xs,0)
   }
   
   println(listLength(xs))
}

//http://aperiodic.net/phil/scala/s-99/