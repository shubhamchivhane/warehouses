package com.anticpu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anticpu.constants.PurchaseOrderStatus;
import com.anticpu.model.Part;
import com.anticpu.service.OrderMethodService;
import com.anticpu.service.PartService;
import com.anticpu.service.PurchaseOrderService;
import com.anticpu.service.UomService;

@Controller
@RequestMapping("/part")
public class PartController {
	
	
	@Autowired
	private UomService uomService;
	
	@Autowired
	private PartService partService;
	
	@Autowired
	private OrderMethodService orderMethodService;
	
	@Autowired
	   private PurchaseOrderService purchaseservice;

	@GetMapping("/register")
	public String showReg(Model model) {
		createChildUi(model);
		return "PartRegister";
	}
	
	@GetMapping("/showlist")
	public String showAllData(Model model) {
		//createChildUi(model);
		model.addAttribute("list", partService.getPartsList());
		return "PartData";
	}
	
	
	
	@PostMapping("/savePart")
	public String savePart(@ModelAttribute Part part,Model model)
	{
		
		Integer id=partService.savePart(part);
		//purchaseservice.updatePurchaseOrderStatus(PurchaseOrderStatus.OPEN.getValue(), id);
		createChildUi(model);
		model.addAttribute("message", "Part id "+id+" successfully saved.");
		return "PartRegister";
		
	}
	
	
	public void createChildUi(Model model){
		   Map<Integer,String>  uoms = uomService.getUomIdAndModel();
		   System.out.println("uoms" +uoms);
		   Map<Integer,String>  order=orderMethodService.getMethodOrderIdAndCode();
		   System.out.println("order" +order);
		   model.addAttribute("uom",uoms);
		  model.addAttribute("order",order);
		}

	
	
}
