package com.anticpu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticpu.constants.SalesOrderStatus;
import com.anticpu.model.SaleOrder;
import com.anticpu.service.SaleOrderService;

@Controller
@RequestMapping("/sale")
public class SaleOrderController {

	@Autowired
	private SaleOrderService service;

	@RequestMapping("/register")
	public String showRegisterForm(Model m) {
		
		createUiForm(m);
		return "salesorder";
	}

	public void createUiForm(Model m) {
		SaleOrder sales = new SaleOrder();
		sales.setStatus(SalesOrderStatus.SALE_OPEN.getValue());
		m.addAttribute("salesOrder", sales);
		Map<Integer, String> shipmentCode = service.getIdAndShipmentCode();
		Map<Integer, String> customer = service.getIdAndCustomer();
		m.addAttribute("customer", customer);
		m.addAttribute("shipmentMap", shipmentCode);

	}
	
	@PostMapping("/saveSales")
	public String saveSO(@ModelAttribute SaleOrder so ,Model m)
	{
		so.setStatus(SalesOrderStatus.SALE_READY.getValue());
		System.out.println(so);
		Integer id=service.saveSO(so);
		m.addAttribute("message", "Sale order created with id :"+id);
		createUiForm(m);
		return "salesorder";
		
	}

}
