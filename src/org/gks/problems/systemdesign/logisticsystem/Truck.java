

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.logisticsystem;


public class Truck extends Vehicle {

  public Truck(int id, String vehicleNo, int capacity) {
    super(id, vehicleNo, capacity);
    // TODO Auto-generated constructor stub
  }

  private final static int capacityofTruck = 100;

  public Truck(int id, String vehicleNo) {
    super(id, vehicleNo, capacityofTruck);
  }
}

