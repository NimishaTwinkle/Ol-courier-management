package com.cg.couriermanagement.service;

import org.springframework.http.ResponseEntity;

import com.cg.couriermanagement.model.ComplaintDTO;

public interface IComplaintService {

	ResponseEntity addnewComplaint(ComplaintDTO complaintDAO);

	ResponseEntity getAllComplaint();

	ResponseEntity getComplaintById(int id);

}
