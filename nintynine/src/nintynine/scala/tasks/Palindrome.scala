package nintynine.scala.tasks

object Palindrome extends App{
	val xs = List(1, 2, 3, 2, 1)
	def isPalindrome(xs:List[Int]):Boolean= {
	 val xsRev = xs.reverse
	 if(xs == xsRev)true else false
	}
	println(isPalindrome(xs))
}