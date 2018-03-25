package com.hotel.booking

import java.util.Date
import java.util.concurrent.{ConcurrentMap, _}

import scala.collection.JavaConverters._
import scala.collection.immutable.HashSet;

class BookingManagerImpl extends BookingManager {

  var bookingList: ConcurrentMap[String, Booking] = new ConcurrentHashMap[String, Booking]()
  val roomList = List(101, 102, 201, 203)

  /**
    * Return true if there is no booking for the given room on the date,
    * otherwise false
    */
  override def isRoomAvailable(room: Int, date: Date): Boolean = {
    val bookingEnqiryDetails = Booking(room, date)
    !bookingList.containsValue(bookingEnqiryDetails)
  }

  /**
    * Add a booking for the given guest in the given room on the given
    * date. If the room is not available, throw a suitable Exception.
    */
  override def addBooking(guest: String, room: Int, date: Date): Unit = {
    //check if room available for given date, if yes, book it
    if (isRoomAvailable(room, date)) {
      val newBooking = Booking(room, date) // guests are unique
      bookingList.put(guest, newBooking)
    }
    else {
      throw new RoomUnavailableException("the room ; " + room + " is not available for the selected date : " + date)
    }

  }

  /**
    * Return a list of all the available room numbers for the given date
    */
  override def getAvailableRooms(date: Date): Seq[Integer] = {

    val bookingObjectList = bookingList.asScala.valuesIterator.toList

    val bookedRoomsList = bookingObjectList
      .toStream
      .filter(booking => booking.date == date)
      .map(booking => booking.room).toList

    val avaialbleRoomsList = roomList
      .toStream
      .filter(room => !bookedRoomsList.contains(room))
      .map(room => Integer.valueOf(room))
      .toList

    return avaialbleRoomsList
  }

}


