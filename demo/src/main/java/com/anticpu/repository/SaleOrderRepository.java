package com.anticpu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anticpu.model.SaleOrder;

@Repository
public interface SaleOrderRepository extends JpaRepository<SaleOrder, Integer> {
	
	@Query("select id ,shipmentCode from ShipmentType where enableShipment='enable'")
	List<Object[]> getIdAndShipmentCode();
	
	@Query("select id ,userCode from WHUserType where userType='Customer'")
	List<Object []> getCustomerFromWH();
}
