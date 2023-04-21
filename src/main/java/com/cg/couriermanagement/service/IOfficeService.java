package com.cg.couriermanagement.service;

import org.springframework.http.ResponseEntity;

import com.cg.couriermanagement.model.CourierOfficeOutletDTO;

public interface IOfficeService {

	ResponseEntity addNewOffice(CourierOfficeOutletDTO courierOfficeOutletDao);

	ResponseEntity getAllOffices();

	ResponseEntity getOfficeById(int id);

	ResponseEntity removeOffice(int id);

}