package com.anticpu.constants;

public enum SalesOrderStatus {

	SALE_OPEN("SALE_OPEN"),SALE_READY("SALE_READY"),SALE_CONFIRM("SALE_CONFIRM"),SALE_INVOICE("SALE_INVOICE"),SALE_SHIPPED("SALE_SHIPPED");
	
	String value;

	private SalesOrderStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
