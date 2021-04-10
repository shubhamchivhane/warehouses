package com.anticpu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anticpu.model.Purchase;


@Repository
public interface PurchaseOrderRepository extends JpaRepository<Purchase, Integer> {

  @Modifying
  @Query("UPDATE Purchase set status =:orderstatus where id =:orderId")
  void updateStatusByOrderId(String orderstatus , Integer orderId);
	
  @Query("SELECT status FROM Purchase where id =:orderId")
  String getOrderStatusByOrderId(Integer orderId);
	
}
