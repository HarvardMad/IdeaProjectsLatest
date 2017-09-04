/*
a set is a function that has the following behaviour (x:Int)=>x<0 this tests
if a number x belongs to the Set of negative numbers
 */
type Set = (Int)=> Boolean
 (n:Int)=> n>0

def contains(s:Set, n:Int):Boolean={
  s(n)
}

contains(n=>n<0,5)

def fn(n:Int)=n==10

def setTwo(n:Int)=n*n+2*n+1==121

contains(n=>n*n+2*n+1==121,10)

//singleton
def singletonSet(n:Int):Set={
  (m:Int)=>m==n
}

def union(s:Set,t:Set):Set={
  (x:Int)=>contains(s,x)||contains(t,x)
}

def intersect(s:Set,t:Set):Set={
  (n:Int)=>contains(s,n) && contains(t,n)
}

def diff(s:Set,t:Set):Set={
  (n:Int)=>contains(s,n) && !contains(t,n)
}
def predicateFunction(n:Int):Boolean={
  n>0
}
//define filter (takes a predicate argument )
def filter(f:Int=>Boolean,s:Set ):Set={
  (x:Int)=>contains(s,x) && f(x)
}
//define forall
val Highbound = 1000
val lowBound = -1000
def forall(f:Int=>Boolean,s:Set):Boolean={
  def loop(n:Int):Boolean={
    if (n > Highbound) true
    else if(contains(s,n) && f(n) )true
    else if (contains(s,n) && !f(n)) false
    else loop(n+1)
  }

  loop(lowBound)
}

def exists(f:Int=>Boolean, s:Set):Boolean={
  !forall(s, x => !f(x))
}

def map(s:Set, f:Int=>Boolean):Set={
  (n:Int)=> exists(s, x => f(x) == n)
}