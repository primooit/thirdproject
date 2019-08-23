package com.primooit.thidproject.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.primooit.thidproject.api.security.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String>{
	
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);

}
