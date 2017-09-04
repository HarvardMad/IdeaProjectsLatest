package nintynine.scala.tasks

object FlattenList extends App{
val xs = List(List(1, 1), 2, List(3, List(5, 8)))
def flatten(ls: List[Any]): List[Any] = ls flatMap {
case ms: List[_] => flatten(ms)
case e => List(e)
}

println(flatten(xs))
}