package com.anticpu.service;

import java.util.List;
import java.util.Optional;

import com.anticpu.model.Document;

public interface DocumentService {

	Integer saveDocument(Document doc);
	List<Object[]> getDocIdAndNames();
	Optional<Document> getDocumentById(int id);
}
