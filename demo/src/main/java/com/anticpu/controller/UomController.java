package com.anticpu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticpu.model.Uom;
import com.anticpu.service.UomService;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private UomService service;
	
	@GetMapping("/register")
	public String showUomForm()
	{
		
		return "Uom";
	}
	
	@PostMapping("/saveUom")
	public String saveUom(@ModelAttribute Uom uom, Model m)
	{
		Integer id=service.saveUom(uom);
		String message = "UOM id:" + id + " saved successfully";
		m.addAttribute("message", message);
		return "uom";
	}
	
	@GetMapping("/alluom")
	public String viewAllUom( Model m)
	{
		return "allUom";
	}
}
