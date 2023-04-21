package com.cg.couriermanagement.service;

import java.util.List;

import com.cg.couriermanagement.entity.CustomerEntity;
import com.cg.couriermanagement.model.Customer;


public interface ICustomerService {

               public CustomerEntity addCustomer(Customer customer);
               public CustomerEntity getCustomerById(int customerId);
               public List<CustomerEntity> getAllCustomerInfo();
			public CustomerEntity addCourier(int custId, int courierId);
			public CustomerEntity addComplaint(int custId, int complaintId);
}
