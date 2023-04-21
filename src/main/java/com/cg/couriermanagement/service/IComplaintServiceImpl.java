package com.cg.couriermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.couriermanagement.entity.ComplaintEntity;
import com.cg.couriermanagement.exception.DoesnotExistsException;
import com.cg.couriermanagement.model.ComplaintDTO;
import com.cg.couriermanagement.repository.IComplaintRepo;
import com.cg.couriermanagement.repository.ICustomerRepo;

@Service
public class IComplaintServiceImpl implements IComplaintService{

	@Autowired
	private ICustomerRepo iCustomerRepo;
	
	@Autowired
	private IComplaintRepo iComplaintRepo;
	
	@Override
	public ResponseEntity addnewComplaint(ComplaintDTO complaintDAO) {
//		if(iCustomerRepo.findById(complaintDAO.getCustomerId()).isPresent())
		{
			ComplaintEntity complaintEntity = new ComplaintEntity();
			complaintEntity.setConsignmentNo(complaintDAO.getConsignmentNo());
			complaintEntity.setShortDescription(complaintDAO.getShortDescription());
			complaintEntity.setLongDescripion(complaintDAO.getLongDescripion());
//			complaintEntity.setCostomer(iCustomerRepo.findById(complaintDAO.getCustomerId()).get());
			complaintEntity = iComplaintRepo.save(complaintEntity);
			return new ResponseEntity<>(complaintEntity,HttpStatus.OK);
		}
//		else {
//			throw new DoesnotExistsException("Customer with this id doesn't exists: "+ complaintDAO.getCustomerId());
//		}
	}

	@Override
	public ResponseEntity getAllComplaint() {
		List<ComplaintEntity> complaintEntityList = iComplaintRepo.findAll();
		return new ResponseEntity<>(complaintEntityList,HttpStatus.OK);
	}

	@Override
	public ResponseEntity getComplaintById(int id) {
		if(iComplaintRepo.findById(id).isPresent()){
			ComplaintEntity complaintEntity = iComplaintRepo.findById(id).get();
			return new ResponseEntity<>(complaintEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Complaint with this id doesn't exists: "+ id);
		}
	}

}
