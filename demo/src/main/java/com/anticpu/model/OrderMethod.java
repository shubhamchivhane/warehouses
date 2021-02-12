package com.anticpu.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class OrderMethod {

	@Id
	@GeneratedValue(generator = "om_seq")
	@SequenceGenerator(name = "om_seq",sequenceName = "om_seq_test")
	private int id;
	private String orderMode;
	private String orderType;
	private String orderCode;
	@ElementCollection
	@CollectionTable(
			name="order_acpt_tab",
			joinColumns = @JoinColumn(name="ord_id_col")
			)
	@Column(name="ord_acpt_col")
	private Set<String> orderAcpt;
	private String orderDescription;
	
	
	
}
