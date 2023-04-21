package com.cg.couriermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.couriermanagement.model.ComplaintDTO;
import com.cg.couriermanagement.service.IComplaintService;

@RequestMapping("/complaint")
@RestController
public class ComplaintController {
	
	@Autowired 
	private IComplaintService iComplaintService;
	
	@PostMapping("/add-complaint")
	ResponseEntity addnewComplaint(@RequestBody ComplaintDTO complaintDAO){
		return iComplaintService.addnewComplaint(complaintDAO);
	}
	
	@GetMapping("/get-all-complaint")
	ResponseEntity getAllComplaint() {
		return iComplaintService.getAllComplaint();
	}
	
	@GetMapping("/get-complaint-by-id")
	ResponseEntity getComplaintById(@RequestParam int id) {
		return iComplaintService.getComplaintById(id);
	}
}
