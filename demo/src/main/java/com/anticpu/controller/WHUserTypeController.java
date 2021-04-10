package com.anticpu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anticpu.model.WHUserType;
import com.anticpu.service.WHUserTypeService;
import com.anticpu.view.WhUserTypeExcelView;

@Controller
@RequestMapping("/whuser")
public class WHUserTypeController {

	@Autowired
	private WHUserTypeService service;
	
	@GetMapping("/register")
	public String showWhUserTypeForm()
	{
		return "WHUser";
	}
	
	@PostMapping("/savewhuser")
	public String addWhUserType(@ModelAttribute WHUserType user,Model m)
	{
		
		Integer id=service.saveWHUserType(user);
		String message="Warehouse Type user "+id+" Saved Successfully";
		m.addAttribute("message", message);
		return "WHUser";
	}
	
	
	@GetMapping("/showlist")
	public String showWhuserList(Model m)
	{
		m.addAttribute("list", getWHUserType());
		System.out.println("showlist");
		return "allWHUser";
	}
	
	@GetMapping("/delete")
	public String deleteWhUser(@RequestParam Integer id,Model m)
	{
		service.deleteWHUserType(id);
		String message="Warehouse Type user "+id+" Deleted Successfully";
		m.addAttribute("lists", getWHUserType());
		m.addAttribute("message", message);
		return "allWHUser";
	}
	
	public List<WHUserType> getWHUserType()
	{   
		List<WHUserType> list= service.getWHUserTypesList();
		System.out.println("+++++++++++++++++++++"+list);
		return list;
	}
	
	@GetMapping("/excel")
	public ModelAndView showExcelData(
			@RequestParam(value = "id", required = false)Integer id
			) 
	{
		//fetch all rows from DB
				List<WHUserType> list =getWHUserType();
				
				//create ModelAndView
				ModelAndView  m = new ModelAndView();
				m.addObject("list", list);
				m.setView(new WhUserTypeExcelView());
				
				return m;
	}
	
}
