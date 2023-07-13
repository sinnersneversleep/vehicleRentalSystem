package com.main.java.mmt.services;

import com.main.java.mmt.models.Booking;
import com.main.java.mmt.services.interfaces.ICalculateBookingAmount;

public class CalculateBookingAmountInMinutes implements ICalculateBookingAmount {

	private static final int ratePerMinute = 2;

	@Override
	public double calculateBookingAmount(Booking booking) {

		return (booking.endTime - booking.startTime) * ratePerMinute;
	}

}
