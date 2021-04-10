package com.anticpu.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.anticpu.model.OrderMethod;

public interface OrderMethodService {

	Integer saveOrderMethod(OrderMethod orderMethod);
	List<OrderMethod> getOrderMethodsList();
	void deleteOrderMethod(Integer id);
	boolean isOrderMethodExist(Integer id);
	OrderMethod getShipmentById(Integer Id);
	Optional<OrderMethod> getOneOrderMethod(Integer id);
	void updateOrderMethod(OrderMethod orderMethod);
	boolean isOrderMethodExistByCode(String orderCode);
	Map<Integer, String> getMethodOrderIdAndCode();
}
