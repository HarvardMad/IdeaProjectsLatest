/*
 Lalin Pethiyagoda
 25/03/2018
 */




package com.hotel.booking

final case class RoomUnavailableException(private val message: String ="",  private val cause: Throwable = None.orNull) extends Exception(message, cause) {

}
