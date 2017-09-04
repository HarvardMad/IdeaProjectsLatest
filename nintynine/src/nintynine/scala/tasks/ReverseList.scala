package nintynine.scala.tasks

object ReverseList extends App{
 val xs = List(1, 1, 2, 10, 5, 8)
 
 def reverse(xs:List[Int]):List[Int]= xs match{
   	case Nil => throw new Error("empty list")  
	case List(x) => List(x)
	case y::ys=> reverse(ys)++ List(y)//10::2::1::1
 }
 
 println(reverse(xs))
}