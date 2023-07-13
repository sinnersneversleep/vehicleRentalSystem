package com.main.java.mmt.models;

public class Booking {

	public int startTime;
	public int endTime;
	public Vehicle vehicle;
	public User user;
	public boolean isComplete;
	public boolean isSuccessFul;
	public Payment payment;

	public Booking(User user, Vehicle vehicle, int startTime, int endTime) {
		this.user = user;
		this.vehicle = vehicle;
		this.endTime = endTime;
		this.startTime = startTime;
	}

	public boolean createBooking() {
		Payment payment = new Payment();
		this.isSuccessFul = payment.acceptPayment();

		return this.isSuccessFul;
	}
}
