package com.anticpu.constants;

public enum PurchaseOrderStatus {

	OPEN("OPEN"),PICKING("PICKING"),ORDERED("ORDERED");
	
	String value;

	private PurchaseOrderStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
