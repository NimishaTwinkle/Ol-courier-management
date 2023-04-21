package com.cg.couriermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.couriermanagement.entity.AppUserEntity;

@Repository
public interface AppUserRepo extends JpaRepository<AppUserEntity,String>{
	
	public Optional<AppUserEntity> findByUserName(String userName);

}

