/*
 Lalin Pethiyagoda
 25/03/2018
 */


package com.hotel.booking.akka

import java.text.SimpleDateFormat

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
/*
 Lalin Pethiyagoda
 25/03/2018
 */

import akka.util.Timeout
import com.hotel.booking.BookingManagerConsole.messagePrinter
import com.hotel.booking.{BookingManager, BookingManagerImpl}

import scala.concurrent.Await
import scala.concurrent.duration._

object HBSActorRunner extends App {

  implicit val timeout = Timeout(5 seconds)
  val bm: BookingManager = new BookingManagerImpl
  val today = new SimpleDateFormat("yyyy-MM-dd").parse("2012-03-28")
  println(bm.isRoomAvailable(101, today))
  bm.addBooking("Smith", 101, today)
  println(bm.isRoomAvailable(101, today))
  bm.addBooking("Jones", 102, today)

  print("Available Rooms ")
  bm.getAvailableRooms(today) foreach (messagePrinter)

  /**
    * Actor Instantiation
    */
  val system = ActorSystem("HBSActor")
  val hotelBookingActor = system.actorOf(Props[HBSActor], "hbsActor")

  //IS ROOM AVAILABLE
  val isRoomAvailableFuture = hotelBookingActor ? IsRoomAvailable(101, today)
  val isRoomAvailableResult = Await.result(isRoomAvailableFuture, timeout.duration).asInstanceOf[IsRoomAvailableResponse]
  println(isRoomAvailableResult)

  //Add Booking
  val addBookingFuture = hotelBookingActor ? AddBooking("Smith", 101, today)
  val addBookingResult = Await.result(addBookingFuture, timeout.duration).asInstanceOf[HotelResponse]
  println(addBookingResult)

  //Attempt to double - book the room
  val doubleBookFuture = hotelBookingActor ? AddBooking("Jones", 101, today)
  val doubleBookResult = Await.result(doubleBookFuture, timeout.duration).asInstanceOf[HotelResponse]
  println(doubleBookResult)


}
