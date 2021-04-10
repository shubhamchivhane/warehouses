package com.anticpu.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.anticpu.model.Uom;

public interface UomService {

	Integer saveUom(Uom uom);
	List<Uom> getUomsList();
	void deleteUom(Integer id);
	boolean isUomExist(Integer id);
	Uom getUomById(Integer Id);
	Optional<Uom> getOneUom(Integer id);
	void updateUom(Uom uom);
	Map<Integer, String> getUomIdAndModel();
}
