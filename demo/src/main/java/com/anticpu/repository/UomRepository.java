package com.anticpu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anticpu.model.Uom;

public interface UomRepository extends JpaRepository<Uom, Integer> {

	
	@Query("Select id ,uomModel from Uom")
	public List<Object[]> getIdAndCodeUom();
	
}
