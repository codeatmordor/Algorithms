

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.hotelbookingsystem;

import java.util.Date;
import java.util.List;

public class Booking {

  int bookingId;
  int userId;
  int hotelId;

  // We are assuming that in a single
  // booking we can book only the rooms
  // of a single hotel
  List<Room> bookedRooms;

  int amount;
  PaymentStatus status_of_payment;
  Date bookingTime;
  Duration duration;

}

