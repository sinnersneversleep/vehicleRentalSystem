package com.main.java.mmt.models;

public class VehicleResponse {
	public int parkingStallNumber;
	public User user;
	public Booking booking;

	public VehicleResponse(int parkingStallNumber, User user, Booking booking) {
		super();
		this.parkingStallNumber = parkingStallNumber;
		this.user = user;
		this.booking = booking;
	}

}
