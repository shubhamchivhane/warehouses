package com.anticpu.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.print.DocFlavor.SERVICE_FORMATTED;

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

import com.anticpu.model.ShipmentType;
import com.anticpu.model.Uom;
import com.anticpu.service.UomService;

@Controller
@RequestMapping("/uom")
public class UomController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UomController.class);

	@Autowired
	private UomService service;

	@GetMapping("/register")
	public String showUomForm() {

		return "Uom";
	}

	@PostMapping("/saveUom")
	public String saveUom(@ModelAttribute Uom uom, Model m) {

		Integer id = service.saveUom(uom);
		String message = "UOM id:" + id + " saved successfully";
		m.addAttribute("message", message);
		return "uom";
	}

	@GetMapping("/alluom")
	public String viewAllUom(Model m) {
		LOGGER.info("inside viewAllUam method [request mapping : /alluom]");
		List<Uom> lists = service.getUomsList();
		
		m.addAttribute("lists", lists);
		System.out.println(lists);
		return "AllUom";
	}

	@GetMapping("/delete")
	public String deleteUom(@RequestParam Integer id, Model m) {
		String message = null;
		if (service.isUomExist(id)) {
			service.deleteUom(id);
			message = new StringBuffer().append("Uom id '").append(id).append("' deleted successfully").toString();
		} else {
			message = new StringBuffer().append("Shipment type '").append(id).append("' not exists").toString();
		}
		m.addAttribute("lists", getListOfUom());
		m.addAttribute("message", message);
		return "AllUom";
	}

	public List<Uom> getListOfUom() {
		LOGGER.info("getting list");
		return service.getUomsList();
	}
	
	@GetMapping("/editUomForm")
	public String editUomForm(@RequestParam Integer id ,Model m) {
		LOGGER.info("inside viewAllUam method [request mapping : /editUomForm]");
		Optional<Uom> opt=service.getOneUom(id);
		String page=null;
		if(opt.isPresent())
		{
			m.addAttribute("uom", opt.get());
			page="EditUomForm";
		}
		else
		{
			page="redirect:all";
		}
		return page;
	}
	
	//updateUom
	
	@PostMapping("/updateUom")
	public String updateUom(@ModelAttribute Uom uom,Model m)
	{
		service.saveUom(uom);
		String message = "UOM id:" + uom.getId() + " updated successfully";
		m.addAttribute("message", message);
		m.addAttribute("lists", getListOfUom());
		return "AllUom";
	}
}
