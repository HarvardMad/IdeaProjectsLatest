
object recur {
  def tailRecFactorial(n: Int): Int = {
    def tail(accumulator: Int, n: Int): Int =
      if (n == 0) accumulator
      else tail(n * accumulator, n)

    tail(1, n)
  }

  tailRecFactorial(5)
}
