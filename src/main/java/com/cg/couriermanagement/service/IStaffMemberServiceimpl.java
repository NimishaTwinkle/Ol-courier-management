package com.cg.couriermanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.couriermanagement.entity.OfficeStaffMemberEntity;
import com.cg.couriermanagement.exception.DoesnotExistsException;
import com.cg.couriermanagement.exception.UnhandledException;
import com.cg.couriermanagement.model.OfficeStaffMemberDTO;
import com.cg.couriermanagement.repository.IOfficeRepo;
import com.cg.couriermanagement.repository.IOfficeStaffRepo;

@Service
public class IStaffMemberServiceimpl implements IStaffMemberService{

	@Autowired
	private IOfficeStaffRepo iOfficeStaffRepo;
	
	@Autowired
	private IOfficeRepo iOfficeRepo;
	
	@Override
	public OfficeStaffMemberDTO addnewstaffmember(OfficeStaffMemberDTO officeStaffMemberDao) {
	 
		OfficeStaffMemberEntity officeStaffMemberEntity = new OfficeStaffMemberEntity();
		BeanUtils.copyProperties(officeStaffMemberDao, officeStaffMemberEntity);
		 
		OfficeStaffMemberEntity newOfficeStaffMemberEntity = iOfficeStaffRepo.save(officeStaffMemberEntity);
		 
		OfficeStaffMemberDTO newStaff = new OfficeStaffMemberDTO();
		BeanUtils.copyProperties(officeStaffMemberEntity, newStaff);
		return newStaff;
	}

	@Override
	public ResponseEntity getAllStaffmembers() {
		List<OfficeStaffMemberEntity> officeStaffMemberEntityList = iOfficeStaffRepo.findAll();
		return new ResponseEntity<>(officeStaffMemberEntityList,HttpStatus.OK);
	}

	@Override
	public ResponseEntity getStaffmemberById(int id) {
		if(iOfficeStaffRepo.findById(id).isPresent()) {
			OfficeStaffMemberEntity officeStaffMemberEntity = iOfficeStaffRepo.findById(id).get();
			return new ResponseEntity<>(officeStaffMemberEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Staff member with this id doenst exists: "+id);
		}
	}

	@Override
	public ResponseEntity removeStaffmember(int id) {
		if(iOfficeStaffRepo.findById(id).isPresent()) {
			OfficeStaffMemberEntity officeStaffMemberEntity = iOfficeStaffRepo.findById(id).get();
			iOfficeStaffRepo.deleteById(id);
			return new ResponseEntity<>(officeStaffMemberEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Staff member with this id doenst exists: "+id);
		}
	}

}
