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
@Table(name="part_tbl")
public class Part {
	
	
	@Id
	@Column(name="part_id")
	@GeneratedValue(generator = "part_gen")
	@SequenceGenerator(name = "part_gen",sequenceName = "part_seq_gen")
	private Integer id;
	
	private String partCode;
	
	private Double partWidth;
	
	private Double partLegth;
	
	private Double partHeigth;
	
	private Double partCost;
	
	private String partCurrency;
	
	private String partDesc;
	
	@ManyToOne
	@JoinColumn(name="uom_id_fk_col")
	private Uom uom; //create HAS-A Variable

	@ManyToOne
	@JoinColumn(name="part_id_fk_col")
	private OrderMethod omSale;
	
}
