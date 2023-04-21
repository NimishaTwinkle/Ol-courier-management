package com.cg.couriermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.couriermanagement.entity.CourierOfficeOutletEntity;
import com.cg.couriermanagement.exception.DoesnotExistsException;
import com.cg.couriermanagement.exception.UnhandledException;
import com.cg.couriermanagement.model.CourierOfficeOutletDTO;
import com.cg.couriermanagement.repository.IOfficeRepo;

@Service
public class IOfficeServiceImpl implements IOfficeService {

	@Autowired
	private IOfficeRepo iOfficeRepo;
	
	@Override
	public ResponseEntity addNewOffice(CourierOfficeOutletDTO courierOfficeOutletDao) {
		try {
			CourierOfficeOutletEntity courierOfficeOutletEntity = new CourierOfficeOutletEntity();
			courierOfficeOutletEntity.setClosingTime(courierOfficeOutletDao.getClosingTime());
			courierOfficeOutletEntity.setOpeningTime(courierOfficeOutletDao.getOpeningTime());
			//courierOfficeOutletEntity.setOfficeStaffMembers(null);
			courierOfficeOutletEntity = iOfficeRepo.save(courierOfficeOutletEntity);
			return new ResponseEntity<>(courierOfficeOutletEntity,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new UnhandledException("Something went wrong");
		}
	}

	@Override
	public ResponseEntity getAllOffices() {
		List<CourierOfficeOutletEntity> courierOfficeOutletEntityList =iOfficeRepo.findAll();
		return new ResponseEntity<>(courierOfficeOutletEntityList,HttpStatus.OK);
	}

	@Override
	public ResponseEntity getOfficeById(int id) {
		if( iOfficeRepo.findById(id).isPresent()) {
			CourierOfficeOutletEntity courierOfficeOutletEntity = iOfficeRepo.findById(id).get();
			return new ResponseEntity<>(courierOfficeOutletEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Office doesnt exists with id: "+id);
		}
	}

	@Override
	public ResponseEntity removeOffice(int id) {
		if( iOfficeRepo.findById(id).isPresent()) {
			CourierOfficeOutletEntity courierOfficeOutletEntity = iOfficeRepo.findById(id).get();
			iOfficeRepo.deleteById(id);
			return new ResponseEntity<>(courierOfficeOutletEntity,HttpStatus.OK);
		}
		else {
			throw new DoesnotExistsException("Office doesnt exists with id: "+id);
		}
	}

}
