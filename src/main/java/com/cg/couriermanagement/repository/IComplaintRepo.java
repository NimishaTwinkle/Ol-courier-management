package com.cg.couriermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.couriermanagement.entity.ComplaintEntity;

@Repository
public interface IComplaintRepo extends JpaRepository<ComplaintEntity,Integer>{
 
}
