/**
 * Created by LalinPethiyagoda on 02/06/2016.
 * use of tail recursion
 * its when the last thing that is done is calling the function itself
 */
object GCD extends App{
  def gcdCalculator(x:Int, y:Int):Int ={
      if(y==0)x
      else gcdCalculator(y, x%y) // dividend = divisor*quotient + remainder
                                  // next iteration:
    /**
     * during subsequent iterations:
     * dividend (x) is replaced with the divisor(y) and
     * divisor is replaced with the remainder (x%y)
     */
  }

  println(gcdCalculator(20,16))
}
