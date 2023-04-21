package com.cg.couriermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.couriermanagement.entity.ComplaintEntity;
import com.cg.couriermanagement.entity.CourierEntity;
import com.cg.couriermanagement.entity.CustomerEntity;
import com.cg.couriermanagement.exception.CustomerNotFoundException;
import com.cg.couriermanagement.model.Customer;
import com.cg.couriermanagement.repository.IComplaintRepo;
import com.cg.couriermanagement.repository.ICourierRepo;
import com.cg.couriermanagement.repository.ICustomerRepo;

@Service
public class ICustomerServiceImpl implements ICustomerService {

               @Autowired
               private ICustomerRepo customerRepo;
               
               @Autowired
               private ICourierRepo courierRepo;

               @Autowired
               private IComplaintRepo complaintRepo;
               
               @Override
               public CustomerEntity addCustomer(Customer customer) {
                              // convert customer model to customer entity
                              CustomerEntity customerEntity = new CustomerEntity();
                              BeanUtils.copyProperties(customer, customerEntity);

                              CustomerEntity newCustomerEntity = customerRepo.save(customerEntity);

                              // convert product entity to product model
                              Customer newCustomer = new Customer();
                              BeanUtils.copyProperties(newCustomerEntity, newCustomer);

                              return newCustomerEntity;
               }

               @Override
               public CustomerEntity getCustomerById(int customerId) {
                              Optional<CustomerEntity> optionalCustomer = customerRepo.findById(customerId);
                              if (optionalCustomer.isEmpty()) {
                                             throw new CustomerNotFoundException("Customer not existing with id: " + customerId);
                              }
                              CustomerEntity customerEntity = optionalCustomer.get();

                              // convert product entity to product model
                              Customer customer = new Customer();
                              BeanUtils.copyProperties(customerEntity, customer);

                              return customerEntity;
               }

               @Override
               public List<CustomerEntity> getAllCustomerInfo() {
        List<CustomerEntity> customerEntities = customerRepo.findAll();
                              
                              //convert product entity list to product list
                              List<Customer> customers = new ArrayList<>();
                              
                              customerEntities.forEach(pentity-> {
                                             Customer customer = new Customer();
                                             BeanUtils.copyProperties(pentity, customer);
                                             customers.add(customer);
                              });                          
                              
                              return customerEntities;
               }

			@Override
			public CustomerEntity addCourier(int custId, int courierId) {
                Optional<CustomerEntity> optionalCustomer = customerRepo.findById(custId);
                if (optionalCustomer.isEmpty()) {
                       throw new CustomerNotFoundException("Customer not existing with id: " + custId);
                }
                CustomerEntity customerEntity = optionalCustomer.get();
                if(courierRepo.findById(courierId).isPresent()) {
                	List<CourierEntity> courierEntity = customerEntity.getCouriers();
                	courierEntity.add(courierRepo.findById(courierId).get());
                	customerEntity.setCouriers(courierEntity);
                	customerEntity = customerRepo.save(customerEntity);
                }
                else {
                    throw new CustomerNotFoundException("Courier not existing with id: " + courierId);
                	
                }

                return customerEntity;
 }

			@Override
			public CustomerEntity addComplaint(int custId, int complaintId) {
                Optional<CustomerEntity> optionalCustomer = customerRepo.findById(custId);
                if (optionalCustomer.isEmpty()) {
                       throw new CustomerNotFoundException("Customer not existing with id: " + custId);
                }
                CustomerEntity customerEntity = optionalCustomer.get();
                if(complaintRepo.findById(complaintId).isPresent()) {
                	List<ComplaintEntity> complaintEntity = customerEntity.getComplaints();
                	complaintEntity.add(complaintRepo.findById(complaintId).get());
                	customerEntity.setComplaints(complaintEntity);
                	customerEntity = customerRepo.save(customerEntity);
                }
                else {
                    throw new CustomerNotFoundException("Complaint not existing with id: " + complaintId);
                	
                }

                return customerEntity;
 }

}
