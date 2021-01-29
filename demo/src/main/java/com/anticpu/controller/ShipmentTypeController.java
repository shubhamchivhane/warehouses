package com.anticpu.controller;

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

import com.anticpu.model.ShipmentType;
import com.anticpu.model.Uom;
import com.anticpu.service.ShipmentTypeService;

@Controller
@RequestMapping("/st")
public class ShipmentTypeController {

	@Autowired
	private ShipmentTypeService service;

	@GetMapping("/register")
	public String shipmentType() {
		System.out.println("testing+++++++++++");
		return "ShipmentType";
	}

	@PostMapping("/saveShipmentType")
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType, Model m) {

		Integer id = service.saveShipmentType(shipmentType);
		String message = "ShipmentType id:" + id + " saved successfully";
		m.addAttribute("message", message);
		return "ShipmentType";
	}

	@PostMapping("/update")
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType, Model m) {

		service.updateShipmentType(shipmentType);
		String message = "ShipmentType id:" + shipmentType.getId() + " updated successfully";
		m.addAttribute("message", message);
		// call service layer for latest data
		List<ShipmentType> list = service.getShipmentTypesList();

		// send data to UI for HTML table
		m.addAttribute("shipmenttypelist", list);

		// Go back to UI page
		return "ShipmentLists";
	}

	@GetMapping("/allst")
	public String allShipmentType(Model m) {
		List<ShipmentType> shipmentList = service.getShipmentTypesList();
		System.out.println(shipmentList);
		m.addAttribute("shipmenttypelist", shipmentList);
		return "ShipmentLists";
	}

	@GetMapping("/delete")
	public String deleteShipmentType(@RequestParam Integer id, Model m) {
		if (service.isShipmentTypeExist(id)) {

			service.deleteShipmentType(id);
			String message = new StringBuffer().append("Shipment type '").append(id).append("' Deleted").toString();
			m.addAttribute("message", message);
		} else {

			String message = new StringBuffer().append("Shipment type '").append(id).append("' not exists").toString();
			m.addAttribute("message", message);
		}

		m.addAttribute("shipmenttypelist", service.getShipmentTypesList());
		return "ShipmentLists";
	}

	@GetMapping("/editShipmentForm")
	public String editshipmentType(@RequestParam Integer id, Model m) {
		
		Optional<ShipmentType> opt=service.getOneShipmentType(id);
		String page=null;
		if(opt.isPresent())
		{
			m.addAttribute("shipmentType", opt.get());
			page="EditShipmentType";
		}
		else
		{
			//Response.sendRedirect()
			page="redirect:all";
		}
		
		return page;
	}
}
