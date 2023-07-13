package com.main.java.mmt.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.main.java.mmt.enums.VehicleType;
import com.main.java.mmt.exceptions.VehicleNotAvailableException;
import com.main.java.mmt.models.Barcode;
import com.main.java.mmt.models.Booking;
import com.main.java.mmt.models.Payment;
import com.main.java.mmt.models.User;
import com.main.java.mmt.models.Vehicle;
import com.main.java.mmt.models.VehicleResponse;
import com.main.java.mmt.services.CalculateBookingAmountInMinutes;
import com.main.java.mmt.services.interfaces.ICalculateBookingAmount;

public class VehicleRentalSystemController {
	Map<VehicleType, List<Vehicle>> vehicleTypeToVehicleListMap = new ConcurrentHashMap<>();
	ICalculateBookingAmount calculateBookingAmount = new CalculateBookingAmountInMinutes();

	List<Booking> bookings = new ArrayList<>();

	public boolean bookVehicle(VehicleType vehicleType, User user, int startTime, int endTime)
			throws VehicleNotAvailableException {
		if (vehicleTypeToVehicleListMap.get(vehicleType).size() == 0) {
			throw new VehicleNotAvailableException(vehicleType.toString() + "is not available");
		}
		Vehicle vehicle = vehicleTypeToVehicleListMap.get(vehicleType).get(0);
		Booking booking = new Booking(user, vehicle, startTime, endTime);
		double cost = calculateBookingAmount.calculateBookingAmount(booking);
		Payment payment = new Payment();
		payment.acceptPayment(cost);

		if (payment.isSuccessFul) {
			System.out.println("Booking is SuccessFul, the cost of Booking is " + cost);
			bookings.add(booking);
		}
		return payment.isSuccessFul;
	}

	public void returnVehicle(Vehicle vehicle, User user) {
		// perform various checks on the vehicle;

		vehicle.isAvailable = true;
		vehicleTypeToVehicleListMap.get(vehicle.vehicleType).add(vehicle);

	}

	public List<Booking> getRentedVehicles() {
		return bookings;
	}

	public VehicleResponse getVehicleLocation(Vehicle vehicle) {
		if (vehicle.isAvailable) {
			return new VehicleResponse(-1, vehicle.booking.user, vehicle.booking);
		} else {
			return new VehicleResponse(vehicle.parkingStallNumber, null, null);
		}
	}

	public void addVehicles() {
		List<Vehicle> cars = new ArrayList<>();
		cars.add(new Vehicle(1, new Barcode(1), VehicleType.Car));
		cars.add(new Vehicle(1, new Barcode(2), VehicleType.Car));

		vehicleTypeToVehicleListMap.put(VehicleType.Car, cars);

	}

	public List<Vehicle> getVehicles(VehicleType vehicleType) {
		return vehicleTypeToVehicleListMap.get(vehicleType);
	}
}
