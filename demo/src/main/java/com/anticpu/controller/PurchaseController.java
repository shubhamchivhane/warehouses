package com.anticpu.controller;

import java.util.List;
import java.util.Map;

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

import com.anticpu.DemoApplication;
import com.anticpu.constants.PurchaseOrderStatus;
import com.anticpu.model.Purchase;
import com.anticpu.model.PurchaseDetails;
import com.anticpu.service.PartService;
import com.anticpu.service.PurchaseDetailsService;
import com.anticpu.service.PurchaseOrderService;
import com.anticpu.service.ShipmentTypeService;
import com.anticpu.service.WHUserTypeService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private ShipmentTypeService shipmentTypeService;

	@Autowired
	private WHUserTypeService whUserTypeService;

	@Autowired
	private PurchaseOrderService purchaseservice;

	@Autowired
	private PurchaseDetailsService purchaseDtlservice;

	@Autowired
	private PartService partService;

	@GetMapping("/register")
	public String showRegister(Model model) {
		Purchase po = new Purchase();
		po.setStatus("OPEN");
		model.addAttribute("purchaseOrder", po);
		createChildUi(model);
		return "purchaseRegister";
	}

	public void createChildUi(Model model) {

		logger.info("createChildUi");

		Map<Integer, String> vendorMap = whUserTypeService.getIdAndVendorCode();
		Map<Integer, String> shipmentCodeMap = shipmentTypeService.getIdAndShipmentCode();
		System.out.println("vendor+++++++++++++" + vendorMap);
		model.addAttribute("vendors", vendorMap);
		model.addAttribute("shipmentMap", shipmentCodeMap);

	}

	// it gives data for Parts DropDown
	private void createChildUiForParts(Model model) {

		logger.info("createChildUiForParts");
		Map<Integer, String> partsMap = partService.getPartIdAndCode();

		model.addAttribute("parts", partsMap);

		System.out.println("parts :+++++++++++++" + partsMap);

	}

	@PostMapping("/savePurchase")
	public String createPurchaseOrder(@ModelAttribute Purchase purchase, Model model) {
		Integer id = purchaseservice.savePurchase(purchase);
		Purchase po = new Purchase();
		po.setStatus("OPEN");
		String msg = "Purchase order id " + id + " successfully created";
		model.addAttribute("purchaseOrder", po);
		model.addAttribute("message", msg);
		createChildUi(model);
		return "purchaseRegister";
	}

	@GetMapping("/parts")
	public String showPurchasePartsPage(@RequestParam("poId") Integer orderId, // PO-ID
			Model model) {
		logger.info("showPurchasePartsPage  poId {} :" + orderId);
		// load PO object by id
		Purchase po = purchaseservice.getOnePurchase(orderId).get();
		model.addAttribute("po", po);
		PurchaseDetails purchaseDtl = new PurchaseDetails();
		purchaseDtl.setPurchase(po);
		createChildUiForParts(model);
		List<PurchaseDetails> lists = purchaseDtlservice.getPurchaseDtlByOrderId(orderId);
		model.addAttribute("list", lists);
		System.out.println("list+++++++++++++" + lists.toString());
		model.addAttribute("purchaseDtl", po);
		return "PurchaseParts";
	}

	// 3. display POs
	@GetMapping("/showlist")
	public String showAll(Model model) {
		List<Purchase> list = purchaseservice.getPurchasesList();
		model.addAttribute("list", list);
		return "PurchaseOrderData";
	}

	@PostMapping("/save")
	public String createPurchaseOrder(@ModelAttribute PurchaseDetails purchasedtl, Model model) {

		Integer poid = purchasedtl.getPurchase().getId();
		Integer id = purchaseDtlservice.savePurchaseDetails(purchasedtl);

		if (purchaseDtlservice.getCountOfItemByOrderId(poid) > 0
				&& !PurchaseOrderStatus.PICKING.getValue().equals(purchaseservice.getOrderStatusByOrderId(poid))) {
			purchaseservice.updatePurchaseOrderStatus(PurchaseOrderStatus.PICKING.getValue(), poid);
		}
		return "redirect:parts?poId=" + poid;
	}

	@GetMapping("/delete")
	public String deletePart(@RequestParam int id, @RequestParam("dtlId") Integer dtlId, Model model) {
		System.out.println(id + "---------------" + dtlId);
		purchaseDtlservice.getOnePurchaseDetails(id);
		if (purchaseDtlservice.getOnePurchaseDetails(id) != null) {
			System.out.println(id + "-----part with id exist---------");
			purchaseDtlservice.deletePurchaseDetails(id);
			if (purchaseservice.getCountByOrderId(dtlId) == 0
					&& !PurchaseOrderStatus.OPEN.getValue().equals(purchaseservice.getOrderStatusByOrderId(id))) {
				purchaseservice.updatePurchaseOrderStatus(PurchaseOrderStatus.OPEN.getValue(), dtlId);
			}
		}
		return "redirect:parts?poId=" + dtlId;
	}

	@GetMapping("/placeOrder")
	public String placeOrder(@RequestParam int poId, Model m) {
		logger.info("Placed order of id :" + poId);
		purchaseservice.updatePurchaseOrderStatus(PurchaseOrderStatus.ORDERED.getValue(), poId);
		return "redirect:parts?poId=" + poId;
	}

}
