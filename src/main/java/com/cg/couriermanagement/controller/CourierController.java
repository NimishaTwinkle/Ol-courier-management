package com.cg.couriermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.couriermanagement.entity.CourierEntity;
import com.cg.couriermanagement.exception.CourierIdNotFoundException;
import com.cg.couriermanagement.model.CourierDTO;
import com.cg.couriermanagement.model.CourierStatus;
import com.cg.couriermanagement.service.ICourierService;

@RequestMapping("/courier")
@RestController
public class CourierController {
	
	@Autowired
	private ICourierService courierService;
	
    @PostMapping("/add")
    public ResponseEntity<CourierEntity> addCourier(@RequestBody CourierDTO courier) {
    	CourierEntity newCourierEntity = courierService.addCourier(courier);
                   ResponseEntity<CourierEntity> responseEntity = new ResponseEntity<>(newCourierEntity,HttpStatus.CREATED);
                   return responseEntity;
    }

    @GetMapping("/check/{courierId}")
    public CourierStatus checkOnlineStatus(@PathVariable("courierId") int courierId) throws CourierIdNotFoundException {
                   CourierStatus courierStatus = courierService.checkOnlineStatus(courierId);
//                ResponseEntity<Courier> responseEntity = new ResponseEntity<>(courierEntity,HttpStatus.OK);
                   
                    return courierStatus;
    }
    
    @GetMapping("/{courierId}")
    public ResponseEntity<CourierDTO> getCourierById(@PathVariable("courierId") int courierId) throws CourierIdNotFoundException{
    	CourierDTO courierEntity = courierService.getCourierById(courierId);
                   ResponseEntity<CourierDTO> responseEntity = new ResponseEntity<>(courierEntity,HttpStatus.OK);
                   return responseEntity;
    }
    
     @GetMapping("/all")
    public List<CourierEntity> getAllCourierInfo(){
                   return courierService.getAllCourierInfo();
    }


}