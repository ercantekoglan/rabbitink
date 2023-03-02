package com.rabbitink.rabbitink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitink.rabbitink.domain.Order;
import com.rabbitink.rabbitink.repository.OrderRepository;

@Service
public class DashboardService {
	
	@Autowired
	private OrderRepository orderRepo;

	public List<Order> findAllByUserId(Long id) {
		
		return orderRepo.findAllByUserId(id);
	}

}
