package com.anticpu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "saleorder_tbl")
public class SaleOrder {

	@Id
	@Column(name="sales_id")
	@GeneratedValue(generator = "sales_gen")
	@SequenceGenerator(name = "sales_gen",sequenceName = "sales_seq_gen")
	private int id;
	
	@Column(name="order_code_col")
	private String orderCode;
	
	@Column(name="reference_no_col")
	private String referenceNo;
	
	@Column(name="stock_mode_col")
	private String stockMode;
	
	@Column(name="stock_source_col")
	private String stockSource;
	
	@Column(name="status")
	private String status;
	
	@Column(name="description")
	private String desc;
	
	@ManyToOne
	@JoinColumn
	private ShipmentType shipment;
	
	@ManyToOne
	@JoinColumn
	private WHUserType warehouse;
	
	
	
}
