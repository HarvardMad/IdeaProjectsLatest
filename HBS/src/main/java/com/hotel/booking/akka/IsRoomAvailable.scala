package com.hotel.booking.akka

import java.util.Date

import com.hotel.booking.BookingManagerImpl

case class IsRoomAvailable(room: Int, date:Date) extends HotelRequest{


}
