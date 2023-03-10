package com.rabbitink.rabbitink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rabbitink.rabbitink.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 @Query("select u from User u"
		      + " left join fetch u.authorities"
		      + " where u.email = :email")
	User findByEmail(String email);
}
