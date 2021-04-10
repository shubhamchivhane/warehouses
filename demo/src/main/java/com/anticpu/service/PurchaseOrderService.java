package com.anticpu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anticpu.model.Purchase;

public interface PurchaseOrderService {

	Integer savePurchase(Purchase purchase);
	List<Purchase> getPurchasesList();
	void deletePurchase(Integer id);
	boolean isPurchaseExist(Integer id);
	Purchase getShipmentById(Integer Id);
	Optional<Purchase> getOnePurchase(Integer id);
	void updatePurchase(Purchase purchase);
	public void updatePurchaseOrderStatus(String orderStatus, Integer orderId);
	public String getOrderStatusByOrderId(Integer orderId);
	public Integer getCountByOrderId(Integer id);
	
	
}
