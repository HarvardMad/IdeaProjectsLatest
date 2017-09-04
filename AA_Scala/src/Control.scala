/**
 * Created by LalinPethiyagoda on 26/01/2016.
 */
object Control {
  def using[A<:{ def close(): Unit},B](resource: A)(f:  A => B) : B =
  try{
      f(resource)
  }finally {
    resource.close()
  }
}
