package com.anticpu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anticpu.model.OrderMethod;
import com.anticpu.service.OrderMethodService;

@Controller
@RequestMapping("/om")
public class OrderMethodController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderMethodController.class);
	
	@Autowired
	private OrderMethodService service;
	
	@RequestMapping("/showOrderMethodForm")
	public String showOrderMethodForm()
	{
		return "OrderMethod";
	}
	//saveOrderMethod
	
	@PostMapping("/saveOrderMethod")
	public String saveOrderMethod(@ModelAttribute OrderMethod orderMethod,Model m)
	{
		LOGGER.info("saveOrderMethod ----> input order Method"+orderMethod);
		Integer id=service.saveOrderMethod(orderMethod);
		String message="Order Method Type id "+id+" saved successfully";
		m.addAttribute("message", message);
		return "OrderMethod";
	}
	
	@GetMapping("/getListOfOrderMethod")
	public String getListofOrderMethodType(Model m)
	{
		List<OrderMethod> list=getListOrderMethod();
		m.addAttribute("list", list);
		System.out.println(list);
		return "OrderMethodData";
	}
	
	@GetMapping("/validateCode")
	public @ResponseBody String validateOrderCode(
			@RequestParam("code") String orderCode
			) 
	{
		String message = "";
		if(service.isOrderMethodExistByCode(orderCode)) {
			message = "Order Method '"+orderCode+"' Exist! Try different!";
		}
		
		return message;
	}
	
	@GetMapping("/delete")
	public String deleteOrderMethod(@RequestParam Integer id , Model m)
	{
		service.deleteOrderMethod(id);
		String message="Order Method Type "+id+" deleted";
		m.addAttribute("message", message);
		m.addAttribute("list", getListOrderMethod());
		return "OrderMethodData";
	}
	
	public List<OrderMethod> getListOrderMethod()
	{
		return service.getOrderMethodsList();
	}

}
