package com.anticpu.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.anticpu.model.Part;


public interface PartService {

	Integer savePart(Part part);
	List<Part> getPartsList();
	void deletePart(Integer id);
	boolean isPartExist(Integer id);
	Part getShipmentById(Integer Id);
	Optional<Part> getOnePart(Integer id);
	void updatePart(Part part);
	Map<Integer, String> getPartIdAndCode();
}
