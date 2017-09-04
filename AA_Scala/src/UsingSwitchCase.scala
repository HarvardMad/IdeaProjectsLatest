/**
 * Created by LalinPethiyagoda on 30/01/2016.
 */
object UsingSwitchCase extends App{

    def identify(x:Any):String = x match{
      case s: String => s + " is a string"
      case s: Int => s + " is an integer"
      case s: Double => s + " is a double"
      case _=> "unknown"
    }

  println(identify("5.2"))

  def checkValue(): Unit ={
    val x = 5
    x match {
      case 1|3|5|7 => println(x + " is odd")
      case 2|4|6|8 => println(x + " is even")
    }
  }

  checkValue

  //assign a match result to a varialble
  // and using a variable rather than the wildcard character _
  val x = 5
  var result:String = x match {
    case 4|2 => "even"
    case 1|3 => "odd"
    case huh => "you said what? " + huh
  }

  println(result)
}
