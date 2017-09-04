println("learning lists")
val xList=List(1,2,3,4,5)
//add an item to the front
val bList = 0::xList
//add an item to the end of the list
val cList = xList:+6
val dList = List(xList,List(8)).flatten
val eList = List(dList,cList).flatten
def factorial(n:Int):Int= n match{
  case 0=>1
  case n=> n * factorial(n-1)
}

factorial(5)
val x = List(1,2,3,4,5)
val y = x.map(x=>factorial(x))




val z = x.map(x=> x match{
  case 0 =>1
  case x => x
})

val fruits=Seq("Apple","Banana","Pears")
fruits.map(_.toUpperCase)
fruits.flatMap(x=>x + "*** " + x)
val kList = List("Hello", "world")
kList.flatMap(x=> x)
val LList = List(1,2,3,4,5)
LList.flatMap(factorial)

