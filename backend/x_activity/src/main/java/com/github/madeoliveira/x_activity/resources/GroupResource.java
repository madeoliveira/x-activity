package com.github.madeoliveira.x_activity.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.madeoliveira.x_activity.entities.Group;
import com.github.madeoliveira.x_activity.services.GroupService;

@RestController
@RequestMapping(value = "/api")
public class GroupResource {

	@Autowired
	private GroupService service;

	@GetMapping(value = "/groups")
	public ResponseEntity<List<Group>> findAll() {
		List<Group> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/groups/{id}")
	public ResponseEntity<Group> findBuId(@PathVariable Long id) {
		Group obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Group> insert(@RequestBody Group obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	@DeleteMapping(value = "/groups/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/groups/{id}")
	public ResponseEntity<Group> update(@PathVariable Long id, @RequestBody Group obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}