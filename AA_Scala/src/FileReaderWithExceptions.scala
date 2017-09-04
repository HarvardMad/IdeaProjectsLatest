/**
 * Created by LalinPethiyagoda on 25/01/2016.
 */
import scala.io.Source
import java.io.{FileNotFoundException, IOException}
class FileReaderWithExceptions {
//use scala's try catch

  object FileReaderWithExceptions extends App{
    val fileName ="/Users/LalinPethiyagoda/Documents/Interview Stuff/ScalaNotes.txt"
    try{
      for(line<-Source.fromFile(fileName).getLines()){
        println(line)
      }
    }catch{
      case ex:FileNotFoundException=> println("file unavailable for processing")
      case ex:IOException => println("Got an IO Exception")
    }
    finally{

    }
  }

  def main(args: Array[String]) {
    FileReaderWithExceptions
  }

}
