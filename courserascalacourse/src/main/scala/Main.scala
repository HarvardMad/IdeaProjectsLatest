/**
 * Created by LalinPethiyagoda on 11/06/2016.
 */
object Main extends App {
  println("Pascal's Triangle")
  for (row <- 0 to 10) {
    for (col <- 0 to row)
      print(pascal(col, row) + " ")
    println()
  }

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

  def balance(chars: List[Char]): Boolean = {

    def balanceHelper(acc: Int, forward: Int, backward: Int, chars: List[Char]): Boolean = {

      if (chars.isEmpty)
        acc == 0
      else {
        val fwd = if (chars.head == '(') forward + 1 else forward
        val bck = if (chars.head == ')') backward + 1 else backward
        if (acc >= 0) balanceHelper(fwd - bck, fwd, bck, chars.tail) else false
      }

    }

    balanceHelper(0, 0, 0, chars)
  }
}
  //def countChange(money: Int, coins: List[Int]): Int={

    /*def countHelper (acc:Int, money:Int, coins: List[Int]):Int= {
      if (coins.isEmpty) 0
      else
        if(money==0)1
      else if (money<=0)0
      else if (money>coins.head)
        //countHelper(acc+1,)
    }
*/
    //countHelper(0, 4, coins)
 // }
//}
