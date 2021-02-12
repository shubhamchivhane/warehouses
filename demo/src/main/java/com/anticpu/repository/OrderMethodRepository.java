package com.anticpu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.anticpu.model.OrderMethod;

@Component
public interface OrderMethodRepository extends JpaRepository<OrderMethod, Integer>{

	
	@Query("SELECT COUNT(om.orderCode) FROM OrderMethod om WHERE om.orderCode=:orderCode")
	public Integer getOrderMethodCountByCode(String orderCode);
}
