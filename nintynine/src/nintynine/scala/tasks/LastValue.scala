package nintynine.scala.tasks

object LastValue extends App{
val aList = List(1,2,4,5,6,8)

def last(xs:List[Int]):Int= xs match{
  case List(x)=>x
  case y::ys=>last(ys)
  
}

println(last(aList))
}