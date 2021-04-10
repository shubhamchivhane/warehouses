package com.anticpu.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anticpu.DemoApplication;
import com.anticpu.model.PurchaseDetails;
import com.anticpu.repository.PurchaseDetailsRepository;
import com.anticpu.service.PurchaseDetailsService;


@Service
public class PurchaseDetailsServiceImpl implements PurchaseDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(PurchaseDetailsServiceImpl.class);
	
	@Autowired
	private PurchaseDetailsRepository repo;
	
	@Override
	public Integer savePurchaseDetails(PurchaseDetails purchaseDetails) {
	
		return repo.save(purchaseDetails).getId();
	}

	@Override
	public List<PurchaseDetails> getPurchaseDetailssList() {
	
		return repo.findAll();
	}

	@Override
	public void deletePurchaseDetails(Integer id) {
	  repo.deleteById(id);

	}

	@Override
	public boolean isPurchaseDetailsExist(Integer id) {
	
		return false;
	}

	@Override
	public PurchaseDetails getShipmentById(Integer Id) {
	
		return null;
	}

	@Override
	public Optional<PurchaseDetails> getOnePurchaseDetails(Integer id) {
	
		return repo.findById(id);
	}

	@Override
	public void updatePurchaseDetails(PurchaseDetails purchaseDetails) {
	

	}

	@Override
	public Map<Integer, String> getIdAndShipmentCode() {
	
		return null;
	}

	@Transactional
	public List<PurchaseDetails> getPurchaseDtlByOrderId(Integer orderId) {
		logger.info("OrderId {} :"+orderId);
		return repo.getPurchaseDtlByOrderId(orderId);
	}

	@Override
	public Integer getCountOfItemByOrderId(Integer orderId) {
		
		return repo.getCountOfItemByOrderId(orderId);
	}

	@Override
	public void delete(Integer id) {
		System.out.println("Delete-------- "+id);
		repo.deleteById(id);
		
	}

}
