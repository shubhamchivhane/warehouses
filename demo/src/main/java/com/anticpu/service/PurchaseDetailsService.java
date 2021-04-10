package com.anticpu.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.anticpu.model.PurchaseDetails;

public interface PurchaseDetailsService {

	Integer savePurchaseDetails(PurchaseDetails purchaseDetails);
	List<PurchaseDetails> getPurchaseDetailssList();
	void deletePurchaseDetails(Integer id);
	boolean isPurchaseDetailsExist(Integer id);
	PurchaseDetails getShipmentById(Integer Id);
	Optional<PurchaseDetails> getOnePurchaseDetails(Integer id);
	void updatePurchaseDetails(PurchaseDetails purchaseDetails);
	List<PurchaseDetails> getPurchaseDtlByOrderId(Integer orderId);
	public Integer getCountOfItemByOrderId(Integer orderId);
	public void delete(Integer id);
	
	Map<Integer,String> getIdAndShipmentCode();
}
