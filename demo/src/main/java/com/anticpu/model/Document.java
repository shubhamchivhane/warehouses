package com.anticpu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class Document {

	@Id
	private Integer docId;
	
	private String docName;
	
	@Lob
	private byte[] docData;
	
}
