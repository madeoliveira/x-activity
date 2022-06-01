package com.github.madeoliveira.x_activity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.madeoliveira.x_activity.entities.Exercise;
import com.github.madeoliveira.x_activity.repositories.ExerciseRepository;

@Service
public class ExerciseService {
	
	@Autowired
	private ExerciseRepository repository;
	
	public List<Exercise>findAll(){
		return repository.findAll();
	}
	
	public Exercise findById(Long id) {
		Optional<Exercise> obj = repository.findById(id);
		return obj.get();
	}
}
