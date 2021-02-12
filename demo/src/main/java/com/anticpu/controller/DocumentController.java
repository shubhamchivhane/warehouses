package com.anticpu.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.anticpu.model.Document;
import com.anticpu.service.DocumentService;

@Controller
@RequestMapping("/doc")
public class DocumentController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	private DocumentService service;
	
	@GetMapping("/show")
	public String showDocUpload(Model m)
	{
		List<Object[]> list = service.getDocIdAndNames();
		m.addAttribute("list", list);
		return "DocumentUpload";
	}
//uploadDoc
	
	@PostMapping("/uploadDoc")
	public String saveDocument(
			@RequestParam("docId")Integer docId,
			@RequestParam("docData")MultipartFile file,Model m)
	{
		if(file != null)
		{
			System.out.println("doc name "+file.getOriginalFilename()+" Doc Id"+docId);
			LOGGER.info("saveDocument ----> input doc Id"+docId+" File :"+file);
			Document doc=new Document();
			doc.setDocId(docId);
			doc.setDocName(file.getOriginalFilename());
			try {
				doc.setDocData(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			LOGGER.info("Document object :" +doc);
			service.saveDocument(doc);
//			if(id>0)
//			{
//				String msg="File Uploaded Successfully";
//			}
//			else
//			{
//				String msg="File Not Uploaded";
//			}
		}
		
		
		m.addAttribute("message", m);
		return "redirect:show";
		
	}
	
	//3. Download
		@GetMapping("/download")
		public void downloadDoc(
				@RequestParam("id")Integer docId,
				HttpServletResponse response
				) 
		{
			Optional<Document> opt = service.getDocumentById(docId);
			if(opt.isPresent()) {
				//read object
				Document doc=opt.get();
				
				//add head section
				response.addHeader(
						"Content-Disposition", 
						"attachment;filename="+doc.getDocName());
				
				//copy data to outputstream from docData
				try {
					//from, to
					FileCopyUtils.copy(
							doc.getDocData(), 
							response.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
