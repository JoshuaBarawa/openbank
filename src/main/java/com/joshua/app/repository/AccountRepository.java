package com.joshua.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joshua.app.model.UserAccount;
import com.joshua.app.model.UserProfile;

@Repository
public interface AccountRepository extends CrudRepository<UserAccount, Long> {

	UserAccount findByUser(UserProfile user);

}
