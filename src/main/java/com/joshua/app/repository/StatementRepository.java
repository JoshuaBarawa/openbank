package com.joshua.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joshua.app.model.MiniStatement;
import com.joshua.app.model.UserProfile;

@Repository
public interface StatementRepository extends CrudRepository<MiniStatement, Long>{

	List<MiniStatement> findByUser(UserProfile user);
	void deleteAllByUser(UserProfile user);
}
