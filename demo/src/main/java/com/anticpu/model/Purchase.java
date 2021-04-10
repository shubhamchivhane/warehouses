package com.anticpu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Purchase {
	
	
	@Id
	@Column(name="purchase_id")
	@GeneratedValue(generator = "purchase_gen")
	@SequenceGenerator(name = "purchase_gen",sequenceName = "purchase_seq_gen")
	private Integer id;
	
	private String orderCode;
	
	private Integer referenceNumber;
	
	private String qualityCheck;
	
	private String status;
	
	private String description;
	
	@ManyToOne
	@JoinColumn
	private ShipmentType shipment;
	
	@ManyToOne
	@JoinColumn
	private WHUserType warehouse;
	

}
