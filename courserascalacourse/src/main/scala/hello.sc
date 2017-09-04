"hello world"
val aList = List(1,2,2,3,4,5,7,8)
aList.last

//using recursion and pattern matching

def lastListValue(ls:List[Int]):Int=ls match{
  case head::Nil=> head
  case head::tail=>
    { if(tail.length>1)
      lastListValue(tail)
      else
        head
    }
  case _ => throw new NoSuchElementException
}

lastListValue(aList)

val xList = List(1,2,3,5,6,6,8)
val bList=List(3,4,5)
val cList= List(6,7,8)
val totList=List(xList,bList,cList).flatten

var result = totList.foldLeft("x")((b,a)=>a+b)

var resTwo = totList.foldLeft(1)((b,a)=>
                                      {
                                        if(a%2==0)
                                          a*b
                                        else a+b
                                      } )
val intList=List(1,2,3,4)
def sum(ls:List[Int]):Int={
  ls.foldLeft[Int](0)((result,current)=>current+result)
}

sum(intList)

def product(ls:List[Int]):Int ={
  ls.foldLeft(1)((result, currentListItem)=>result*currentListItem)
}

product(intList)


def count(ls:List[Int]):Int= {ls.foldLeft(0)((result, currentListItem)=> result+1)}

count(intList)


def average(ls:List[Double]):Double={
  ls.foldLeft(1.0)((result,currVal) => result + currVal)/ls.length
}



















