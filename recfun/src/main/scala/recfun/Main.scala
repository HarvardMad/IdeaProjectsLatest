package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  val chrList = "((hello world)))".toList
  println(chrList)
  println(balance(chrList))

  def pascal(c: Int, r: Int): Int = {
    def fact(n: Int): Int = {
      // use factorial to work out each position in the triangle
      if (n == 0) 1
      else n * fact(n - 1)
    }
    fact(r) / (fact(c) * fact(r - c))
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def balanceHelper(acc: Int, forward: Int, backward: Int, chars: List[Char]): Boolean = {

      if (chars.isEmpty)
        acc == 0
      else {
        val fwd = if (chars.head == '(') forward + 1 else forward
        val bck = if (chars.head == ')') backward + 1 else backward
        if (acc >= 0) balanceHelper(fwd - bck, fwd, bck, chars.tail)
        else false
      }
    }
    balanceHelper(0, 0, 0, chars)
  }

  /**
   * Exercise 3
   */
  val intList =List(1,2)
  val anotherList =List(5,10,20,50,100,200,500)
  def countChange(money: Int, coins: List[Int]): Int={
    def moneyHelper(money:Int, coins:List[Int]):Int={
      if(money==0)1
      else if((money<0)||(coins.size==0))0

      else moneyHelper(money-coins.head, coins)+moneyHelper(money,coins.tail)
    }
    moneyHelper(money,coins)
  }

  println("count change " + countChange(300,anotherList))
}
