package com.bridgelabz.fundoouser.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.fundoouser.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmailId(String emailId);

}
