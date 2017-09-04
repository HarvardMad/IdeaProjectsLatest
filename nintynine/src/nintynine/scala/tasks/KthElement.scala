package nintynine.scala.tasks

object KthElement extends App{
  val xs = List(1, 1, 2, 10, 5, 8)
  
  def nth(n:Int, xs:List[Int]):Int={
    def nthElement(n:Int, xs:List[Int],acc:Int):Int=xs match{
      case Nil => throw new Error("empty list")
      case List(x)=> x
      case y::ys =>{
    	  			if(n==acc)y else nthElement(n,ys,acc+1)
      }
    }
    
    nthElement(n,xs,0)
  }

  println(nth(3,xs))
}