package com.main.java.mmt.services;

import java.util.List;

import com.main.java.mmt.enums.VehicleType;
import com.main.java.mmt.models.Vehicle;
import com.main.java.mmt.services.interfaces.VehicleFilter;

public class VehicleTypeFilter implements VehicleFilter {
	public VehicleType vehicleType;

	public VehicleTypeFilter(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public List<Vehicle> getVehicles(List<Vehicle> vehicles) {
		return vehicles.stream().filter(vehicle -> vehicle.vehicleType.equals(this.vehicleType)).toList();
	}

}
