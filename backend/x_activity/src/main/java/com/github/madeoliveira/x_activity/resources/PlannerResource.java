package com.github.madeoliveira.x_activity.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.madeoliveira.x_activity.entities.Planner;
import com.github.madeoliveira.x_activity.services.PlannerService;

@RestController
@RequestMapping(value = "/api")
public class PlannerResource {

	@Autowired
	private PlannerService service;

	@GetMapping(value = "/planners")
	public ResponseEntity<List<Planner>> findAll() {
		List<Planner> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/planners/{id}")
	public ResponseEntity<Planner> findBuId(@PathVariable Long id) {
		Planner obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	


}