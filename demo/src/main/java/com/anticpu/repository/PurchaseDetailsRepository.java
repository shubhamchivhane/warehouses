package com.anticpu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anticpu.model.PurchaseDetails;

@Repository
public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Integer> {

	
	@Query("SELECT pdtl FROM PurchaseDetails pdtl INNER JOIN pdtl.purchase as po WHERE po.id=:orderId")
	List<PurchaseDetails> getPurchaseDtlByOrderId(Integer orderId);
	
	@Query("SELECT count(pdtl.id) FROM PurchaseDetails pdtl INNER JOIN pdtl.purchase as po WHERE po.id=:orderId")
	Integer getCountOfItemByOrderId(Integer orderId);
}
