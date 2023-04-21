package com.cg.couriermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.couriermanagement.model.CourierDTO;
import com.cg.couriermanagement.model.CourierOfficeOutletDTO;
import com.cg.couriermanagement.service.IOfficeService;

@RequestMapping("/office")
@RestController
public class OfficeController {
	
	@Autowired
	private IOfficeService iOfficeService;
	
	@PostMapping("/add-office")
	ResponseEntity addNewOffice(@RequestBody CourierOfficeOutletDTO courierOfficeOutletDao){
		return iOfficeService.addNewOffice(courierOfficeOutletDao);
	}
	

	
	@GetMapping("/get-all-offices")
	ResponseEntity getAllOffices() {
		return iOfficeService.getAllOffices();
	}
	
	@GetMapping("/get-office-by-id")
	ResponseEntity getOfficeById(@RequestParam int id) {
		return iOfficeService.getOfficeById(id);
	}
	
	@DeleteMapping("/remove-office")
	ResponseEntity removeOffice(@RequestParam int id) {
		return iOfficeService.removeOffice(id);
	}
}
