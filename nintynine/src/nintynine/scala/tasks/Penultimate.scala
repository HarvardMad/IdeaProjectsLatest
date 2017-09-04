package nintynine.scala.tasks

object Penultimate extends App{
val xs = List(1, 1, 2, 3, 5,7,34,8)

def penultimate(xs:List[Int]):Int= xs match{
  case Nil => throw new Error("empty list")
  case List(x,y) => xs.head
  case y::ys => penultimate(ys)
}

println(penultimate(xs))
}

/**
 * Web answers 
 * object P02 {
  // Again, with builtins this is easy.
  def penultimateBuiltin[A](ls: List[A]): A =
    if (ls.isEmpty) throw new NoSuchElementException
    else ls.init.last

  // But pattern matching also makes it easy.
  def penultimateRecursive[A](ls: List[A]): A = ls match {
    case h :: _ :: Nil => h
    case _ :: tail     => penultimateRecursive(tail)
    case _             => throw new NoSuchElementException
  }
* 
*/

