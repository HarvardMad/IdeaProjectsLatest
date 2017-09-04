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

def product(f:Int=>Int)(a:Int,b:Int):Int={
  if(a>b)1
  else
    f(a)*product(f)(a+1,b)
}

var d= product(x=>x)(1,1)
def waitingForRange= product(x=>x)(_,_)
waitingForRange(1,5)

def factorial(n:Int):Int=product(n=>n)(1,n)

factorial(5)

def gen(f:Int=>Int)(a:Int,b:Int):Int={
  if(a-b>0)
    f(a)*gen(f)(a+1,b)
  else
    f(a)+ gen(f)(a+1,b)
}
