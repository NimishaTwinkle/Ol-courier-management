package com.cg.couriermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.couriermanagement.model.OfficeStaffMemberDTO;
import com.cg.couriermanagement.service.IStaffMemberService;

@RequestMapping("/staffmember")
@RestController
public class StaffMemberController {

	@Autowired
	private IStaffMemberService iStaffMemberService;
	
	@PostMapping("/add-staffmember")
	public OfficeStaffMemberDTO addnewstaffmember(@RequestBody OfficeStaffMemberDTO officeStaffMemberDao){
		return iStaffMemberService.addnewstaffmember(officeStaffMemberDao);
	}
	
	@GetMapping("/get-all-staffmembers")
	ResponseEntity getAllStaffmembers() {
		return iStaffMemberService.getAllStaffmembers();
	}
	
	@GetMapping("/get-staffmember-by-id")
	ResponseEntity getStaffmemberById(@RequestParam int id) {
		return iStaffMemberService.getStaffmemberById(id);
	}
	
	@DeleteMapping("/remove-staffmember")
	ResponseEntity removeStaffmember(@RequestParam int id) {
		return iStaffMemberService.removeStaffmember(id);
	}
}	
