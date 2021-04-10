package com.anticpu.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticpu.model.Part;
import com.anticpu.repository.PartRepository;
import com.anticpu.service.PartService;
import com.anticpu.util.AppUtil;

@Service
public class PartServiceImpl implements PartService {

	@Autowired
	private PartRepository partRepo;
	
	@Override
	public Integer savePart(Part part) {
		     
		return partRepo.save(part).getId();
	}

	@Override
	public List<Part> getPartsList() {
		
		return partRepo.findAll();
	}

	@Override
	public void deletePart(Integer id) {
		
		partRepo.deleteById(id);
		
	}

	@Override
	public boolean isPartExist(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Part getShipmentById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Part> getOnePart(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePart(Part part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, String> getPartIdAndCode() {
		 List<Object[]> list=partRepo.getPartIdAndCode();
		 
		return AppUtil.convertToMap(list);
	}

	

}
