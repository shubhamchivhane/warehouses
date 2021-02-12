package com.anticpu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anticpu.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

	
	@Query("SELECT docId,docName FROM Document")
	List<Object []> getNameAndDoc();
}
