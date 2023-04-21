package com.cg.couriermanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.couriermanagement.entity.CourierEntity;
import com.cg.couriermanagement.exception.ItemNotFoundException;
import com.cg.couriermanagement.model.CourierStatus;
import com.cg.couriermanagement.service.IShipmentService;

@RestController
@RequestMapping("/courier")
public class ShipmentController {
	
	@Autowired
	private IShipmentService shipmentService;
	
	@PutMapping("/start")
	public CourierEntity initiateShipment(int courier)throws ItemNotFoundException {
		CourierEntity courierEntity = shipmentService.initiateShipment(courier);
		return courierEntity;
	}
	
	@PutMapping("/update/{courier}")
	public CourierEntity initiateShipment(@PathVariable int courier, CourierStatus courierStatus)throws ItemNotFoundException  {
		CourierEntity courierEntity = shipmentService.updateShipment(courier, courierStatus);
		return courierEntity;
	}
	
	
	@GetMapping("/close")
	public String closeShipment(@RequestParam int courier)throws ItemNotFoundException {
		String courierEntity = shipmentService.closeShipment(courier);
		return courierEntity;
		
	}
	
	@PutMapping("/reject")
	public CourierEntity rejectShipment(@RequestParam int courier) throws ItemNotFoundException{
		CourierEntity courierEntity = shipmentService.rejectShipment(courier);
		return courierEntity;
	}

	
	@GetMapping("/checkstatus")
	public CourierStatus checkShipmentStatus(@RequestParam int courier) throws ItemNotFoundException{
		CourierStatus courierEntity = shipmentService.checkShipmentStatus(courier);
		return courierEntity;
	}
	
}









