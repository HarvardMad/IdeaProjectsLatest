/**
 * Created by LalinPethiyagoda on 27/01/2016.
 */
object UsingForWithYield extends App{
//use yield when
  // you want to create a new collection
  // from an existing collection
  //by applying an algorithm to each
  // element of the original collection

  // using a for loop with yield
  // is known as for comprehension

  val names = Array("lalin", "prasadi", "georgia")

  val cappedNames = for(x <-names) yield x.capitalize

  for(y <- cappedNames) {
    println(y.length)
  }
}
