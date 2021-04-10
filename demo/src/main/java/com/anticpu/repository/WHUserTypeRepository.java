package com.anticpu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anticpu.model.WHUserType;

@Repository
public interface WHUserTypeRepository extends JpaRepository<WHUserType, Integer> {

	
	@Query("select id,userType from WHUserType where userType='Vendor'")
	public List<Object []> getIdAndVendor();
	
	
	
}
