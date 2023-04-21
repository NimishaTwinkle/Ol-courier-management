package com.cg.couriermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.couriermanagement.entity.CustomerEntity;
import com.cg.couriermanagement.model.Customer;
import com.cg.couriermanagement.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
@Autowired
private ICustomerService customerService;

 @PostMapping("/add")
               public ResponseEntity<CustomerEntity> addCustomer(@RequestBody Customer customer) {
	 CustomerEntity newCustomer = customerService.addCustomer(customer);
                              ResponseEntity<CustomerEntity> responseEntity = new ResponseEntity<>(newCustomer,HttpStatus.CREATED);
                              return responseEntity;                   
               }
               
               @GetMapping("/{customerId}")
               public  ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("customerId") int customerId) {
            	   CustomerEntity customer = customerService.getCustomerById(customerId);
                              ResponseEntity<CustomerEntity> responseEntity = new ResponseEntity<>(customer,HttpStatus.OK);
                              return responseEntity;
               }
               
               @GetMapping("/all")
               public List<CustomerEntity> getAllCustomerInfo() {
                              List<CustomerEntity> customers = customerService.getAllCustomerInfo();
                              return customers;
               }
               @PostMapping("/addCourier")
               public CustomerEntity addCourier(@RequestParam int custId, @RequestParam int courierId) {
            	   return customerService.addCourier(custId,courierId);
               }
               
               @PostMapping("/addComplaint")
               public CustomerEntity addComplaint(@RequestParam int custId, @RequestParam int complaintId) {
            	   return customerService.addComplaint(custId,complaintId);
               }
}
