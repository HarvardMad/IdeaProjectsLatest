package com.hotel.booking.akka

import java.text.SimpleDateFormat
import java.util.Date

import com.hotel.booking.{BookingManager, BookingManagerImpl, RoomUnavailableException}
import akka.actor.{Actor, ActorSystem, Props}


class HBSActor extends Actor {

  val manager = new BookingManagerImpl

  override def receive: Receive = {

    case IsRoomAvailable(room,date) => sender() ! roomAvailability(room,date)
    case AddBooking(name,room,date) => sender() ! respondToAddBooking(name,room,date)
    case _ => sender() ! ErrorOccured()

  }


  def roomAvailability(room:Int,date:Date):IsRoomAvailableResponse ={

    if(manager.isRoomAvailable(room,date)){
      RoomAvaiable()
    }
    else{
      NoRoomAvailable()
    }
  }

  def respondToAddBooking(name:String,room:Int, date:Date):HotelResponse={

    try{
      manager.addBooking(name,room,date)
      BookingMade()
    }catch{
      case ru: RoomUnavailableException => ErrorOccured()
    }

  }
}
