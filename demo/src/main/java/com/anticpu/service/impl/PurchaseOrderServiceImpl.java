package com.anticpu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anticpu.model.Purchase;
import com.anticpu.repository.PurchaseDetailsRepository;
import com.anticpu.repository.PurchaseOrderRepository;
import com.anticpu.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository repo;
	
	@Autowired
	private PurchaseDetailsRepository purchaseDetailsrepo;
	
	@Override
	public Integer savePurchase(Purchase purchase) {
		
		return repo.save(purchase).getId();
	}

	@Override
	public List<Purchase> getPurchasesList() {
		
		return repo.findAll();
	}

	@Override
	public void deletePurchase(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public boolean isPurchaseExist(Integer id) {
		
		return repo.existsById(id);
	}

	@Override
	public Purchase getShipmentById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Purchase> getOnePurchase(Integer id) {
		
		return repo.findById(id);
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public void updatePurchaseOrderStatus(String orderStatus, Integer orderId) {
		repo.updateStatusByOrderId(orderStatus, orderId);
		
	}

	@Override
	public String getOrderStatusByOrderId(Integer orderId) {
		
		return repo.getOrderStatusByOrderId(orderId);
	}

	@Override
	public Integer getCountByOrderId(Integer id) {
		
		return purchaseDetailsrepo.getCountOfItemByOrderId(id);
	}



}
