package com.anticpu.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticpu.model.SaleOrder;
import com.anticpu.repository.SaleOrderRepository;
import com.anticpu.service.SaleOrderService;
import com.anticpu.util.AppUtil;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {

	@Autowired
	private SaleOrderRepository repo;
	
	@Override
	public Integer saveSO(SaleOrder so) {
		
		return repo.save(so).getId();
	}

	@Override
	public List<SaleOrder> getSaleOrdersList() {
		
		return repo.findAll();
	}

	@Override
	public void deleteSaleOrder(Integer id) {
		

	}

	@Override
	public boolean isSaleOrdereExist(Integer id) {
		
		return repo.existsById(id);
	}

	@Override
	public SaleOrder getSaleOrderById(Integer Id) {
		
		return repo.getOne(Id);
	}

	@Override
	public Optional<SaleOrder> getOneSaleOrder(Integer id) {
		
		return repo.findById(id);
	}

	@Override
	public void updateSaleOrder(SaleOrder so) {
		

	}

	@Override
	public Map<Integer, String> getIdAndShipmentCode() {
		List<Object[]> obs=repo.getIdAndShipmentCode();
		return AppUtil.convertToMap(obs);
	}

	@Override
	public Map<Integer, String> getIdAndCustomer() {
		 List<Object []> ob=repo.getCustomerFromWH();
		return AppUtil.convertToMap(ob);
	}

}
