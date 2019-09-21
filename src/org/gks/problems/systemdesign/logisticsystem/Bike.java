

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.logisticsystem;


public class Bike extends Vehicle {

  public Bike(int id, String vehicleNo, int capacity) {
    super(id, vehicleNo, capacity);
    // TODO Auto-generated constructor stub
  }

  private final static int capacityofBike = 10;

  public Bike(int id, String vehicleNo) {

    super(id, vehicleNo, capacityofBike);
  }

}

