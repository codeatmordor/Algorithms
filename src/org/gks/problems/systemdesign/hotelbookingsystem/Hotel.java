

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.hotelbookingsystem;

import java.util.List;

public class Hotel {

  int hotelId;
  String hotelName;
  Address adress;

  // hotel contains the list of rooms
  List<Room> rooms;
  float rating;
  Facility facilities;
}

