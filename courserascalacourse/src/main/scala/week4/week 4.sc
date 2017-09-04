


abstract class Nat{
  def isZero:Boolean;
  def predecessor:Nat
  def successor:Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat{
  override def isZero():Boolean=true
  def predecessor():Nat=throw new Error("0.predecessor")
  def successor=new Succ(this)
  def + (that: Nat): this + that
  def - (that: Nat): Nat
}

class Succ(n:Nat) extends Nat {
  def isZero =false
  def predecessor:Nat = n
}

object List{
  val head:Int
  val tail:Int
  List() => Nil
  List(x:Int) => this.head=n
}