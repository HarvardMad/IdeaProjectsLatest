def sum(f:Int=>Int):(Int,Int)=>Int= {
  //function retured by sum()
  def sumF(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  }

  sumF // returns sumF
}
  def returnedSumF = sum(x=>x*x*x)
var x=returnedSumF(1,3)


def nextSum(f:Int=>Int)(a:Int,b:Int):Int={
  if(a>b)0
  else
    f(a)+ nextSum(f)(a+1,b)
}
nextSum(x=>x*x*x)(1,3)


val k=nextSum(x=>x+1)(1,10)
def ns = nextSum(x=>x+1)(_,_)

var e=ns(1,10)


