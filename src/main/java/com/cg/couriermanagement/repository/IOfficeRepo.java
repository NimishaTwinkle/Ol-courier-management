package com.cg.couriermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.couriermanagement.entity.CourierOfficeOutletEntity;

@Repository
public interface IOfficeRepo  extends JpaRepository<CourierOfficeOutletEntity,Integer> {

}
