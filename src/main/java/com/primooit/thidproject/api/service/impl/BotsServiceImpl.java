package com.primooit.thidproject.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.primooit.thidproject.api.repository.ChangeStatusRepository;
import com.primooit.thidproject.api.repository.BotsRepository;
import com.primooit.thidproject.api.security.entity.ChangeStatus;
import com.primooit.thidproject.api.security.entity.Bots;
import com.primooit.thidproject.api.service.BotsService;

@Component
public class BotsServiceImpl implements BotsService {
	
	@Autowired
	private BotsRepository botsRepository;
	
	@Autowired
	private ChangeStatusRepository changeStatusRepository;

	public Bots createOrUpdate(Bots bots) {
		return this.botsRepository.save(bots);
	}

	public Optional<Bots> findById(String id) {
		return this.botsRepository.findById(id);
	}

	public void delete(String id) {
		this.botsRepository.deleteById(id);
	}

	public Page<Bots> listTicket(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.botsRepository.findAll(pages);
	}
	
	public Iterable<Bots> findAll() {
		return this.botsRepository.findAll();
	}
	
	public Page<Bots> findByCurrentUser(int page, int count, String userId) {
		Pageable pages = PageRequest.of(page, count);
		return this.botsRepository.findByUserIdOrderByDateDesc(pages,userId);
	}

	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		return this.changeStatusRepository.save(changeStatus);
	}
	
	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		return this.changeStatusRepository.findByTicketIdOrderByDateChangeStatusDesc(ticketId);
	}
	
	public Page<Bots> findByParameters(int page, int count,String title,String status,String priority) {
		Pageable pages = PageRequest.of(page, count);
		return this.botsRepository.
				findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(title, status, priority, pages);
	}
	
	public Page<Bots> findByParametersAndCurrentUser(int page, int count,String title,String status,
			String priority,String userId) {
		Pageable pages = PageRequest.of(page, count);
		return this.botsRepository.
				findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(title, status, priority, pages);
	}
	
	public Page<Bots> findByNumber(int page, int count,Integer number){
		Pageable pages = PageRequest.of(page, count);
		return this.botsRepository.findByNumber(number, pages);
	}
	
	public Page<Bots> findByParametersAndAssignedUser(int page, int count,String title,String status,
			String priority,String assignedUserId) {
		Pageable pages = PageRequest.of(page, count);
		return this.botsRepository.
				findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(title, status, priority, pages);
	}


}