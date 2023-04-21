package com.cg.couriermanagement.service;

import org.springframework.http.ResponseEntity;

import com.cg.couriermanagement.model.OfficeStaffMemberDTO;

public interface IStaffMemberService {

	public OfficeStaffMemberDTO addnewstaffmember(OfficeStaffMemberDTO officeStaffMemberDao);

	ResponseEntity getAllStaffmembers();

	ResponseEntity getStaffmemberById(int id);

	ResponseEntity removeStaffmember(int id);

}
