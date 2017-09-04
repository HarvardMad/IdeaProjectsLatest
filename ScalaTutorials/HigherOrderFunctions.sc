object sumOfList{
  val x=List(2,3,5,7)
  def sumList(x:List[Int]):Int={
    def sumListHelper(x:List[Int],acc:Int):Int= x match {
      case Nil=>acc // list is empty
      case x::tail=>sumListHelper(tail,acc+x)
    }
    sumListHelper(x,0)
  }
  sumList(x)
}



import scala.annotation.tailrec
object fibo{
  def fibonacci(n:Int):Int= {
    @tailrec def fiboHelper(n: Int, previous: Int, current:Int): Int = n match {
      case 0=> previous //if n = 0 then
      case _ => fiboHelper(n-1,current,previous+current) // if anything else next = previous+current
      }
    fiboHelper(n,0,1) // seed values F0 =0 F1=1
    }
    fibonacci(6)
}



object tail{
  def factorialtailRec(n:Int):Int={
    @tailrec def facHelper(n:Int, acc:Int):Int={
      if(n==0||n==1)acc
      else facHelper(n - 1, acc * n)
    }
    facHelper(n,1)
  }
  factorialtailRec(10)
}

