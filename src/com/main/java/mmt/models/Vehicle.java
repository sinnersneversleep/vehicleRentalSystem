package com.main.java.mmt.models;

import com.main.java.mmt.enums.VehicleType;

public class Vehicle {
	public Booking booking;
	public VehicleType vehicleType;
	public Barcode barcode;
	public boolean isAvailable;
	public int parkingStallNumber;

	public Vehicle(int parkingStallNumber, Barcode barcode, VehicleType car) {
		this.barcode = barcode;
		this.parkingStallNumber = parkingStallNumber;
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleType=" + vehicleType + ", barcode=" + barcode + ", parkingStallNumber="
				+ parkingStallNumber + "]";
	}

}
