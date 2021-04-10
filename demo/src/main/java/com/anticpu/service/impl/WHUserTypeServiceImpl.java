package com.anticpu.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticpu.model.WHUserType;
import com.anticpu.repository.WHUserTypeRepository;
import com.anticpu.service.WHUserTypeService;
import com.anticpu.util.AppUtil;

@Service
public class WHUserTypeServiceImpl implements WHUserTypeService {

	@Autowired
	private WHUserTypeRepository repo;
	
	@Override
	public Integer saveWHUserType(WHUserType wHUserType) {
		return repo.save(wHUserType).getId();
	}

	@Override
	public List<WHUserType> getWHUserTypesList() {
	
		return repo.findAll();
	}

	@Override
	public void deleteWHUserType(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public boolean isWHUserTypeExist(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WHUserType getWHUserTypeById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<WHUserType> getOneWHUserType(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateWHUserType(WHUserType HUserType) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Integer, String> getIdAndVendorCode() {
		
		 List<Object []> list=repo.getIdAndVendor();
		 
		return AppUtil.convertToMap(list);
	}

}
