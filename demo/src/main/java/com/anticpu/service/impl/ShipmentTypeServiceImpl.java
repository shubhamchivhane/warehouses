package com.anticpu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticpu.model.ShipmentType;
import com.anticpu.repository.ShipmentTypeRepository;
import com.anticpu.service.ShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements ShipmentTypeService{

	@Autowired
	private ShipmentTypeRepository repository;
	
	@Override
	public Integer saveShipmentType(ShipmentType shipmentType) {
		
		ShipmentType shipment=repository.save(shipmentType);
		Integer shipmentId=shipment.getId();
		return shipmentId;
	}

	@Override
	public List<ShipmentType> getShipmentTypesList() {
		
		return repository.findAll();
	}

	@Override
	public void deleteShipmentType(Integer id) {
		  repository.deleteById(id);
	}

	@Override
	public boolean isShipmentTypeExist(Integer id) {
		
		return repository.existsById(id);
	}

	@Override
	public ShipmentType getShipmentById(Integer Id) {
		// TODO Auto-generated method stub
		return repository.getOne(Id);
	}

	@Override
	public void updateShipmentType(ShipmentType shipmentType) {
	         repository.save(shipmentType);
		
	}

	@Override
	public Optional<ShipmentType> getOneShipmentType(Integer id) {
		return repository.findById(id);
	}

	
}
