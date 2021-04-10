package com.anticpu.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.anticpu.model.WHUserType;

public interface WHUserTypeService {

	
	Integer saveWHUserType(WHUserType wHUserType);
	List<WHUserType> getWHUserTypesList();
	void deleteWHUserType(Integer id);
	boolean isWHUserTypeExist(Integer id);
	WHUserType getWHUserTypeById(Integer Id);
	Optional<WHUserType> getOneWHUserType(Integer id);
	void updateWHUserType(WHUserType HUserType);
	
	Map<Integer,String> getIdAndVendorCode();
	
}
