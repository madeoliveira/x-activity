package com.github.madeoliveira.x_activity.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.madeoliveira.x_activity.entities.User;
import com.github.madeoliveira.x_activity.services.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/users/page")
	public ResponseEntity<Page<User>> findAll(Pageable pageable) {
		Page<User> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/users/{id}")
	public ResponseEntity<User> findBuId(@PathVariable Long id) {
		User obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/users")
	public ResponseEntity<User> insert(@RequestBody @Valid User obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/users/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}