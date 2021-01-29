package com.anticpu.service;

import java.util.List;
import java.util.Optional;

import com.anticpu.model.ShipmentType;

public interface ShipmentTypeService {

	Integer saveShipmentType(ShipmentType shipmentType);
	List<ShipmentType> getShipmentTypesList();
	void deleteShipmentType(Integer id);
	boolean isShipmentTypeExist(Integer id);
	ShipmentType getShipmentById(Integer Id);
	Optional<ShipmentType> getOneShipmentType(Integer id);
	void updateShipmentType(ShipmentType shipmentType);
	
}
