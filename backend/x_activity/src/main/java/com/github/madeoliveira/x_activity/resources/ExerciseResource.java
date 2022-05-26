package com.github.madeoliveira.x_activity.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.madeoliveira.x_activity.entities.Exercise;
import com.github.madeoliveira.x_activity.services.ExerciseService;

@RestController
@RequestMapping(value = "/exercises")
public class ExerciseResource {

	@Autowired
	private ExerciseService service;

	@GetMapping
	public ResponseEntity<List<Exercise>> findAll() {
		List<Exercise> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Exercise> findBuId(@PathVariable Long id) {
		Exercise obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}