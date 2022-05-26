package com.github.madeoliveira.x_activity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.madeoliveira.x_activity.entities.Planner;
import com.github.madeoliveira.x_activity.repositories.PlannerRepository;

@Service
public class PlannerService {
	
	@Autowired
	private PlannerRepository repository;
	
	public List<Planner>findAll(){
		return repository.findAll();
	}
	
	public Planner findById(Long id) {
		Optional<Planner> obj = repository.findById(id);
		return obj.get();
	}
	
}
