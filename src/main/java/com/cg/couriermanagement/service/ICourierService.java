package com.cg.couriermanagement.service;

import java.util.List;

import com.cg.couriermanagement.entity.CourierEntity;
import com.cg.couriermanagement.exception.CourierIdNotFoundException;
import com.cg.couriermanagement.exception.CustomerNotFoundException;
import com.cg.couriermanagement.model.CourierDTO;
import com.cg.couriermanagement.model.CourierStatus;



public interface ICourierService {
public CourierEntity addCourier(CourierDTO courier) throws CustomerNotFoundException;
public CourierStatus checkOnlineStatus(int courierId) throws CourierIdNotFoundException;
public CourierDTO getCourierById(int courierId) throws CourierIdNotFoundException;
public List<CourierEntity> getAllCourierInfo();
}
