package com.primooit.thidproject.api.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.primooit.thidproject.api.security.entity.Bots;

public interface BotsRepository extends MongoRepository<Bots, String>{
	
	Page<Bots> findByUserIdOrderByDateDesc(Pageable pages, String userId);
	
	Page<Bots> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
			String title, String status, String priority, Pageable pages);
	
	Page<Bots> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
			String title, String status, String priority, Pageable pages);
	
	Page<Bots> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc
	(String title, String status, String priority, Pageable pages);
	
	Page<Bots> findByNumber(Integer number, Pageable pages);

}
