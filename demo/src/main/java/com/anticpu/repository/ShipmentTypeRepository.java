package com.anticpu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anticpu.model.ShipmentType;

public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Integer> {
	
	
	@Query("select id,shipmentCode from ShipmentType where enableShipment='enable'")
	public List<Object []> getIdAndVendor();

}
