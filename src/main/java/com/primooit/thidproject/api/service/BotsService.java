package com.primooit.thidproject.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.primooit.thidproject.api.security.entity.ChangeStatus;
import com.primooit.thidproject.api.security.entity.Bots;

@Component
public interface BotsService {
	
	Bots createOrUpdate(Bots bots);
	
	Optional<Bots> findById(String bot);
	
	void delete(String id);
	
	Page<Bots> listTicket(int page, int count);
	
	ChangeStatus createChangeStatus(ChangeStatus changeStatus);

	Page<Bots> findByCurrentUser(int page, int count, String userId);
	
	Page<Bots> findByParameters(int page, int count, String title, String status, String priority);
	
	Page<Bots> findByParametersAndCurrentUser(int page, int count, String title, String status, String priority, String userId);
	
	Page<Bots> findByNumber(int page, int count, Integer number);
	
	Iterable<Bots> findAll();
	
	Page<Bots> findByParametersAndAssignedUser( int page, int count, String title, String status, String priority, String assignedUser);
	
	
}
