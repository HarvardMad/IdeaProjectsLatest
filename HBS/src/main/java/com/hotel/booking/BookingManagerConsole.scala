package com.hotel.booking

import java.text.SimpleDateFormat

@throws(classOf[Exception])
object BookingManagerConsole extends App {
  val bm:BookingManager = new BookingManagerImpl
  val today = new SimpleDateFormat("yyyy-MM-dd").parse("2012-03-28")
  println(bm.isRoomAvailable(101,today))
  bm.addBooking("Smith",101,today)
  println(bm.isRoomAvailable(101, today))
  bm.addBooking("Jones", 102, today)

 print("Available Rooms ")
  bm.getAvailableRooms(today) foreach(messagePrinter)


  def messagePrinter(x:AnyRef):Unit = {
    print(x + " ")
  }


}
