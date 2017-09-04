/**
 * Created by LalinPethiyagoda on 02/06/2016.
 */
object NthElement extends App{
  val aList = List(1,2,3,5,6,6,8)

  def findNthElement(num:Int, ls:List[Int]):Unit={

    def findElementHelper(num:Int, acc:Int, ls:List[Int]):AnyVal=ls match {
      case head::Nil => {if (num >1)  acc}
      case head::tail=> {
        if(num==acc){
          head
        }
        else{
          findElementHelper(num, acc+1, tail)
        }

      }
      case _ => throw new NoSuchElementException
    }
    println(findElementHelper(num,1,ls))
  }

  findNthElement(4,aList)
}
