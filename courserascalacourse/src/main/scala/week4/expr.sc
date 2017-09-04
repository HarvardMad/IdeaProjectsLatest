trait Expr{

  def isNumber:Boolean
  def isSum : Boolean
  def numValue : Int
  def leftOp : Expr
  def rightOp :Expr

}

class Number(n:Int) extends Expr{
  def isNumber:Boolean=true
  def isSum : Boolean=false
  def numValue : Int=n
  def leftOp : Expr= throw new Error("no left operand")
  def rightOp :Expr = throw new Error("no right  operand")
}

class Sum(expOne:Expr, expTwo:Expr) extends Expr{
  def isNumber:Boolean=false
  def isSum : Boolean=true
  def numValue : Int= throw new Error("not a number but a sum")
  def leftOp : Expr= expOne
  def rightOp :Expr = expTwo
}

object ExprRunner extends App{
  def eval(e:Expr):Int={
    if(e.isNumber)e.numValue
    else if(e.isSum) e.leftOp.numValue + e.rightOp.numValue
    else throw new Error("something went wrong ")
  }
}