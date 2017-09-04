/**
 * Created by LalinPethiyagoda on 26/01/2016.
 * using closes the reader when it goes out of scope
 */
import Control._
import io.Source._
object FileReaderWithUsingMethod extends App {

  val fileName ="/Users/LalinPethiyagoda/Documents/Interview Stuff/ScalaNotes.txt"


    def readTextFile(fileName:String):Option[List[String]]={
      try{
        val linesInAList = using(io.Source.fromFile(fileName)){
          source =>(for(line <- source.getLines)yield line).toList
        }
        //return an option type Some()
        Some(linesInAList)
      }
      catch{
        case e:Exception =>None
      }

  }

  var x = readTextFile(fileName)

  println(x)

}
