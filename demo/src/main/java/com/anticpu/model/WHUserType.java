package com.anticpu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class WHUserType {
	
	@Id
	@Column(name="wh_user_id")
	@GeneratedValue
	private int id;
	
	@NotNull
	private String userType;
	
	@NotNull
	private String userCode;
	
	@NotNull
	private String usedFor;
	
	@NotNull
	private String userEmail;
	
	@NotNull
	private String userContact;
	
	@NotNull
	private String userIdType;
	
	@NotNull
	private String other;
	
	@NotNull
	private String userIdNumber;
	
	

}
