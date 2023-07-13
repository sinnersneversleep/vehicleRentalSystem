package com.main.java.mmt.services.interfaces;

import java.util.List;

import com.main.java.mmt.models.Vehicle;

public interface VehicleFilter {
	List<Vehicle> getVehicles(List<Vehicle> vehicles);
}
