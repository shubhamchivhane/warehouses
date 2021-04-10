package com.anticpu.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.anticpu.model.SaleOrder;

public interface SaleOrderService {

	Integer saveSO(SaleOrder so);
	List<SaleOrder> getSaleOrdersList();
	void deleteSaleOrder(Integer id);
	boolean isSaleOrdereExist(Integer id);
	SaleOrder getSaleOrderById(Integer Id);
	Optional<SaleOrder> getOneSaleOrder(Integer id);
	void updateSaleOrder(SaleOrder so);
	
	Map<Integer,String> getIdAndShipmentCode();
	
	Map<Integer ,String> getIdAndCustomer();
	
}
