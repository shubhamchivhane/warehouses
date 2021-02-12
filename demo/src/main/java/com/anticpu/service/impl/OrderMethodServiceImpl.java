package com.anticpu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticpu.model.OrderMethod;
import com.anticpu.repository.OrderMethodRepository;
import com.anticpu.service.OrderMethodService;

@Service
public class OrderMethodServiceImpl implements OrderMethodService {
	
	@Autowired
	private  OrderMethodRepository repo;
	
	@Override
	public Integer saveOrderMethod(OrderMethod orderMethod) {
		
		OrderMethod ordMethod=repo.save(orderMethod);
		Integer id=ordMethod.getId();
		return id;
	}

	@Override
	public List<OrderMethod> getOrderMethodsList() {
	
		return repo.findAll();
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public boolean isOrderMethodExist(Integer id) {
		
		return repo.existsById(id);
	}

	@Override
	public OrderMethod getShipmentById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<OrderMethod> getOneOrderMethod(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderMethod(OrderMethod orderMethod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOrderMethodExistByCode(String orderCode) {
		/*Integer count = repo.getOrderMethodCountByCode(orderCode);
		boolean exist = count>0? true:false;
		return exist;*/
		return  repo.getOrderMethodCountByCode(orderCode) > 0;
	}

}
