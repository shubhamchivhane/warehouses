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
public class PurchaseDetails {

	@Id
	@Column(name="purchase_id")
	@GeneratedValue(generator = "purchase_gen")
	@SequenceGenerator(name = "purchase_gen",sequenceName = "purchase_seq_gen")
	public int id;
	
	public int qty;
	
	@ManyToOne
	@JoinColumn
	public Purchase purchase;
	
	@ManyToOne
	@JoinColumn
	public Part part;

}
