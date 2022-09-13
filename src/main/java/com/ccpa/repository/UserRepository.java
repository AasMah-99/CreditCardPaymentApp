package com.ccpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccpa.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("From User u WHERE u.userId =:uUserId AND u.password =:uPass")
	User getUserByUserIdAndPassword(@Param("uUserId") String userId, @Param("uPass") String password);
}
