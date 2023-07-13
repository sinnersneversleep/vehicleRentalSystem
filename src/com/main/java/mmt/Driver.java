package com.main.java.mmt;

import com.main.java.mmt.controllers.VehicleRentalSystemController;
import com.main.java.mmt.enums.VehicleType;
import com.main.java.mmt.exceptions.VehicleNotAvailableException;
import com.main.java.mmt.models.User;

public class Driver {
	public static void main(String[] args) {
		VehicleRentalSystemController vehicleRentalSystemController = new VehicleRentalSystemController();
		vehicleRentalSystemController.addVehicles();
		User user = new User("Some", "some@gmail.com");

		// book vehicle flow and calculation of Booking
		try {
			boolean bookingSuccessFul = vehicleRentalSystemController.bookVehicle(VehicleType.Car, user, 12, 30);
			if (bookingSuccessFul) {
				System.out.println("Booking is successful");
			}
		} catch (VehicleNotAvailableException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		// get available vehicles flow
		System.out.println(vehicleRentalSystemController.getVehicles(VehicleType.Car));
		;

		System.out.println();

	}
}
/*
 * Models: User(Email, name), Vehicle(Barcode, Enum Vehicle Type, isAvailable),
 * Booking, Reservation,
 *
 */

/*
 * Machine Coding: Vehicle Rental System Description Implement a vehicle rental
 * system to rent out vehicles to users and manage inventory.
 *
 * Assumptions Assume user accounts already exist in the system with email as a
 * unique identifier. Assume any rates to rent vehicles. < Add more assumptions
 * here if you have any >
 *
 * Requirements (Implement in order) Design class Structures for all the
 * entities required. Figure out all the entities in the application and design
 * a data model / class structure for each one of them, storing essential
 * information.
 *
 * List Available Vehicles: From the inventory, return the vehicles which are
 * free for a given time duration by user. // type = All/Car/SUV // isAvailable
 * = true/false // timeFrame = Similar to hotel booking (Define properly)
 *
 * Book a Vehicle: The system will support the renting of different automobiles
 * like cars, trucks, SUVs, vans, and motorcycles. Each vehicle should be added
 * with a unique barcode and other details, including a parking stall number
 * which helps to locate the vehicle. Given a vehicle, startDateTime and
 * duration, book a vehicle for that particular time. The vehicle should be
 * marked unavailable only for the given time frame and should be available for
 * others.
 *
 * Calculate amount to pay: Given a booking which contains vehicle, user, time
 * frame for booking etc, calculate total amount the user needs to pay. Assume
 * any rate of the vehicle.
 *
 * Return a vehicle: After booking complete, mark the vehicle as
 * returned/available and end the booking when the user returns the vehicle.
 *
 * List of rented out vehicles: List all the rented out vehicles with their
 * current tenant, due date, etc. List<Booking>
 *
 * Locate a vehicle: Return current status of vehicle. If it is rented, return
 * the booking and user. If free, return the parking lot number where the
 * vehicle is parked.
 *
 *
 * Other Notes Use local IDE to code. You can use any language, any IDE/editor.
 * Write a driver class for demo purposes. Which will execute all the commands
 * in one place in the code and implement test cases. Recommended not to use any
 * database or NoSQL store, use in-memory data-structure for now i.e store data
 * in global variables. Do not create any UI for the application. Please
 * prioritize code compilation, execution, and completion. We expect a working
 * solution in the end. Work on the expected output first and then add
 * good-to-have features of your own. Hard wire 2 test cases in the driver class
 * and run your solution on them.
 *
 *
 */