package com.joshua.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joshua.app.model.UserProfile;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends CrudRepository<UserProfile, Long>{
	

	UserProfile findByEmail(String email);
	UserProfile findByUserName(String name);
}
