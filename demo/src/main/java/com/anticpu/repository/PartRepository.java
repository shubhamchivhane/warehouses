package com.anticpu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anticpu.model.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {

	@Query("SELECT id, partCode  FROM Part")
	List<Object[]> getPartIdAndCode();
	
}
