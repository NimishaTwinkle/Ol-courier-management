package com.cg.couriermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.couriermanagement.entity.CourierEntity;

@Repository
public interface ICourierRepo extends JpaRepository<CourierEntity,Integer>{

}
