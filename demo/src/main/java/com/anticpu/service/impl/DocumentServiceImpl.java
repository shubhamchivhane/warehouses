package com.anticpu.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticpu.model.Document;
import com.anticpu.repository.DocumentRepository;
import com.anticpu.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentRepository repo;

	@Override
	public Integer saveDocument(Document doc) {
		 
		try {
			 repo.save(doc);
		} catch (Exception e) {
			System.out.println("++++++++++++++++++Exception at  saveDocument()++++++++++++++++++++++="+e);
			e.printStackTrace();
		}
		return doc.getDocId();
	}

	@Override
	public List<Object[]> getDocIdAndNames() {
		// TODO Auto-generated method stub
		return repo.getNameAndDoc();
	}

	@Override
	public Optional<Document> getDocumentById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
