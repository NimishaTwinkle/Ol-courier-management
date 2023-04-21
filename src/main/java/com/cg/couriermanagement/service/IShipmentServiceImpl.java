package com.cg.couriermanagement.service;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.couriermanagement.entity.CourierEntity;
import com.cg.couriermanagement.exception.ItemNotFoundException;
import com.cg.couriermanagement.model.CourierStatus;
import com.cg.couriermanagement.repository.ICourierRepo;

@Service
public class IShipmentServiceImpl implements IShipmentService{

	@Autowired
	private ICourierRepo repo;
	
	@Override
	public CourierEntity initiateShipment(int courier) throws ItemNotFoundException {
		// TODO Auto-generated method stub
		Optional<CourierEntity> optionalCourierEntity = repo.findById(courier);
		if(optionalCourierEntity.isEmpty()) {
			throw new ItemNotFoundException("Courier Item Not Found");
		}
		else {
			CourierEntity courierEntity = optionalCourierEntity.get();
			courierEntity.setCourierStatus(CourierStatus.INITIATED);
			courierEntity = repo.save(courierEntity);
			return courierEntity;
		}
	}
	
	@Override
	public CourierEntity updateShipment(int courier, CourierStatus courierStatus)throws ItemNotFoundException{
		Optional<CourierEntity> optionalCourierEntity = repo.findById(courier);
		if(optionalCourierEntity.isEmpty()) {
			throw new ItemNotFoundException("Courier Item Not Found");
		}
		else {
			CourierEntity courierEntity = this.repo.findById(courier).get();
			if(courierStatus.toString().equals("INITIATED")) {
				courierEntity.setInitiatedDate(LocalDate.now());
			}
			else if(courierStatus.toString().equals("DELIVERED")) {
				courierEntity.setDeliveredDate(LocalDate.now());
			}
			courierEntity.setCourierStatus(courierStatus);
			return this.repo.save(courierEntity);
		}
	}

	
	
	@Override
	public String closeShipment(int courier)throws ItemNotFoundException {
		// TODO Auto-generated method stub
		Optional<CourierEntity> optionalCourierEntity = repo.findById(courier);
		if(optionalCourierEntity.isEmpty()) {
			throw new ItemNotFoundException("Courier Item Not Found");
		}
		else {
			CourierEntity courierEntity = optionalCourierEntity.get();
			if(courierEntity.getCourierStatus().equals(CourierStatus.DELIVERED)) {
				return "Shipment is delivered and closed";
			}
			else {
				return "Shipment is not yet closed";
			}
		}

	}
	
	@Override
	public CourierEntity rejectShipment(int courier) throws ItemNotFoundException{
		Optional<CourierEntity> optionalCourierEntity = repo.findById(courier);
		if(optionalCourierEntity.isEmpty()) {
			throw new ItemNotFoundException("Courier Item Not Found");
		}
		else {
			CourierEntity courierEntity = optionalCourierEntity.get();
			courierEntity.setCourierStatus(CourierStatus.REJECTED);
			courierEntity = repo.save(courierEntity);
			return courierEntity;
		}
		
	}

	@Override
	public CourierStatus checkShipmentStatus(int courier) throws ItemNotFoundException{
		// TODO Auto-generated method stub
		Optional<CourierEntity> optionalCourierEntity = repo.findById(courier);
		if(optionalCourierEntity.isEmpty()) {
			throw new ItemNotFoundException("Courier Item Not Found");
		}
		else {
			CourierEntity courierEntity = optionalCourierEntity.get();
			CourierStatus status = courierEntity.getCourierStatus();
			return status;
		}
		
	}
	
	
}














//if(repo.findById(courier.getCourierid()).isPresent()) {
//	//CourierEntity  courierEntity = repo.findById(courier).get();
//	courier.setCourierStatus(CourierStatus.INITIATED);
//	courier = repo.save(courier);
//	return courier;
//}
//else {
//	throw new ItemNotFoundException("Courier Item Not Found");
//}







//Optional<CourierEntity> courierEntity = repo.findById(courier.getCourierid());
//if(courierEntity == null) {
//	throw new ItemNotFoundException("Courier Item Not Found");
//}
//else {
//	CourierEntity c = new CourierEntity();
//	String status = c.getCourierStatus().toString();
////	CourierEntity entity = repo.findById(courier).orElseThrow(null);
////	String status = courierEntity.getCourierStatus().toString();
//	return status;
//}









//if(repo.findById(courier.getCourierid()).isPresent()) {
////CourierEntity  courierEntity = repo.findById(courier).get();
//String status = courier.getCourierStatus().toString();
//if(status.equals(CourierStatus.DELIVERED.toString())) {
//	return "Shipment is delivered and closed";
//}
//else {
//	return "Shipment is not yet closed";
//}
//}
//else {
//throw new ItemNotFoundException("Courier Item Not Found");
//}
//else{
//String status = courierEntity.getCourierStatus().toString();
//if(status.equals(CourierStatus.DELIVERED.toString())) {
//	return "Shipment is delivered and closed";
//}
//else {
//	return "Shipment is not yet closed";
//}
//}

