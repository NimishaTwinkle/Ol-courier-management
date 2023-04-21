package com.cg.couriermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.couriermanagement.entity.CustomerEntity;

@Repository
public interface ICustomerRepo extends JpaRepository<CustomerEntity,Integer> {

}
