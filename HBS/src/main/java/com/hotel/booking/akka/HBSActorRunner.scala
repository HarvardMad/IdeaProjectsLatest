package com.hotel.booking.akka
import java.text.SimpleDateFormat

import akka.actor.{Actor, ActorSystem, Props}
import com.hotel.booking.{BookingManager, BookingManagerImpl}
import com.hotel.booking.BookingManagerConsole.messagePrinter

import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration.{Duration, SECONDS}

object HBSActorRunner extends App{

  val bm:BookingManager = new BookingManagerImpl
  val today = new SimpleDateFormat("yyyy-MM-dd").parse("2012-03-28")
  println(bm.isRoomAvailable(101,today))
  bm.addBooking("Smith",101,today)
  println(bm.isRoomAvailable(101, today))
  bm.addBooking("Jones", 102, today)

  print("Available Rooms ")
  bm.getAvailableRooms(today) foreach(messagePrinter)

  /**
    * Actor Instantiation
    */
  val system = ActorSystem("HBSActor")
  val hotelBookingActor = system.actorOf(Props[HBSActor],"hbsActor")


  //sending messages
  println(hotelBookingActor ? IsRoomAvailable(101,today))
  println(hotelBookingActor ? AddBooking("Smith",101,today))
  println(hotelBookingActor ? AddBooking("Jones",101,today))

}
