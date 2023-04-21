package com.cg.couriermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.couriermanagement.entity.CourierEntity;
import com.cg.couriermanagement.entity.CustomerEntity;
import com.cg.couriermanagement.exception.CourierIdNotFoundException;
import com.cg.couriermanagement.exception.CustomerNotFoundException;
import com.cg.couriermanagement.model.CourierDTO;
import com.cg.couriermanagement.model.CourierStatus;
import com.cg.couriermanagement.repository.ICourierRepo;
import com.cg.couriermanagement.repository.ICustomerRepo;

@Service
public class ICourierServiceImpl implements ICourierService{


	@Autowired
	private ICustomerRepo customerRepo;
	
	@Autowired
	private ICourierRepo courierRepo;
	
	@Override
    public CourierEntity addCourier(CourierDTO courier) throws CustomerNotFoundException {
        Optional<CustomerEntity> optionalCustomer = customerRepo.findById(courier.getCustomerId());
//        if(optionalCustomer.isEmpty()) {
//            throw new CustomerNotFoundException("Customer not existing with id: "+courier.getCustomerId());
//        }
        CustomerEntity customerEntity = optionalCustomer.get();
        //convert Courier model to Courier Entity
        CourierEntity courierEntity = new CourierEntity();
        BeanUtils.copyProperties(courier, courierEntity);    
//        courierEntity.setCustomer(customerEntity);
//        courierEntity.setCustomer(customerEntity);
        CourierEntity newCourierEntity = courierRepo.save(courierEntity);
        //convert Courier entity to Courier model
        CourierDTO newCourier = new CourierDTO();
        newCourierEntity.getCourierStatus();
        BeanUtils.copyProperties(newCourierEntity, newCourier);
//        newCourier.setCustomerId(newCourierEntity.getCustomer().getCustomerId());
        return newCourierEntity;
    }

	@Override
    public CourierDTO getCourierById(int courierId) throws CourierIdNotFoundException {
        Optional<CourierEntity> optionalCourier = courierRepo.findById(courierId);
        if(optionalCourier.isEmpty()) {
            throw new CourierIdNotFoundException("Courier not existing with id: "+courierId);
        }
        CourierEntity courierEntity = optionalCourier.get();
        //convert courier entity to courier model
        CourierDTO courier = new CourierDTO();
        
        BeanUtils.copyProperties(courierEntity, courier);
        courier.setCourierStatus(courier.getCourierStatus());
//        courier.setCourierStatus(com.cg.couriermanagement.model.CourierStatus.INTRANSIT);
        return courier ;
    }


	

	@Override
    public List<CourierEntity> getAllCourierInfo() {
        List<CourierEntity> courierEntities = courierRepo.findAll();
        //convert courier entity list to courier list
        List<CourierDTO> couriers = new ArrayList<>();
        courierEntities.forEach(pentity->{
        	CourierDTO courier = new CourierDTO();
            BeanUtils.copyProperties(pentity, courier);
//            courier.setCustomerId(pentity.getCustomer().getCustomerId());
            couriers.add(courier);
        });
        return courierEntities;
    }


    @Override
    public CourierStatus checkOnlineStatus(int courierId) throws CourierIdNotFoundException {
        Optional<CourierEntity> optionalCourier = courierRepo.findById(courierId);
//        Courier couriers = courierRepo.findById(courierId);
        if(optionalCourier.isEmpty()) {
            throw new CourierIdNotFoundException("Courier not existing with id: "+courierId);
        }
        CourierEntity courierEntity = optionalCourier.get();
        //BeanUtils.copyProperties(optionalCourier, courier);
        CourierStatus courierStatus = courierEntity.getCourierStatus();
        return courierStatus;
    }



}
