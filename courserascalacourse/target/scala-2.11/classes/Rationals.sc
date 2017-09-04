class Rational(x:Int, y:Int){

  def numer = x
  def denom = y

  def add(r:Rational): Rational ={
    new Rational(numer*r.denom+r.numer*denom,denom*r.denom)
  }

  def neg():Rational={
    new Rational(-numer,denom)
  }

  def subtract(r:Rational):Rational={add(r.neg)
    //new Rational(numer*r.denom-r.numer*denom,numer*r.denom)
  }

  private def gcdCalculator(x:Int, y:Int):Int ={
    if(y==0)x
    else gcdCalculator(y, x%y) // dividend = divisor*quotient + remainder
    // next iteration:
    /**
     * during subsequent iterations:
     * dividend (x) is replaced with the divisor(y) and
     * divisor is replaced with the remainder (x%y)
     */
  }

  def toString(r:Rational):String={
    val g= gcdCalculator(numer,denom)
    r.numer/g + "/" + r.denom/g
  }
}

val x = new Rational(1,3)
x.numer
x.denom

val y = new Rational(5,7)

x.toString(x.add(y))

val z = new Rational(3,2)

def addRational(r:Rational, s:Rational):Rational={
  var newNumer =r.numer*s.denom + s.numer*r.denom
  var newDenom=r.denom*s.denom
  new Rational(newNumer,newDenom)
}

def makeString(r:Rational):String={
  r.numer + "/" + r.denom
}

makeString(addRational(new Rational(1,2), new Rational(2,3)))

x.toString(x.add(y.neg()).add(z.neg()))

x.toString(x.subtract(y).subtract(z))
