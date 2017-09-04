import java.io.{IOException, FileNotFoundException}

import scala.io.Source

/**
 * Created by LalinPethiyagoda on 25/01/2016.
 */
object FR extends App{
  val fileName ="/Users/LalinPethiyagoda/Documents/Interview Stuff/ScalaNotes.txt"
  try{
    for(line<-Source.fromFile(fileName).getLines()){
      println(line)
    }
  }catch{
    case ex:FileNotFoundException=> println("file unavailable for processing")
    case ex:IOException => println("Got an IO Exception")
  }
}
