package com.rabbitink.rabbitink.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rabbitink.rabbitink.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findAllByUserId(Long id);

	

}
