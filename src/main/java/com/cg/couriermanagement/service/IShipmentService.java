package com.cg.couriermanagement.service;

import com.cg.couriermanagement.entity.CourierEntity;
import com.cg.couriermanagement.exception.ItemNotFoundException;
import com.cg.couriermanagement.model.CourierStatus;

public interface IShipmentService {

	public CourierEntity initiateShipment(int courier) throws ItemNotFoundException;
	public CourierEntity updateShipment(int courier, CourierStatus courierStatus)throws ItemNotFoundException;
	public String closeShipment(int courier)throws ItemNotFoundException;
	public CourierEntity rejectShipment(int courier)throws ItemNotFoundException;
	public CourierStatus checkShipmentStatus(int courier) throws ItemNotFoundException;
	
}
