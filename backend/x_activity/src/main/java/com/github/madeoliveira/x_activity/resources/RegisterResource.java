package com.github.madeoliveira.x_activity.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.madeoliveira.x_activity.entities.Register;
import com.github.madeoliveira.x_activity.services.RegisterService;

@RestController
@RequestMapping(value = "/api")
public class RegisterResource {

	@Autowired
	private RegisterService service;


	@GetMapping(value = "/registers")
	public ResponseEntity<List<Register>> findAll() {
		List<Register> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/registers/{id}")
	public ResponseEntity<Register> findBuId(@PathVariable Long id) {
		Register obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/registers/{id}")
	public ResponseEntity<Register> inset(@PathVariable Long id, @RequestBody Register obj) {
		obj = service.insertRegister(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	

//	@DeleteMapping(value = "/registers/{id}")
//	public ResponseEntity<Void> delete(@PathVariable Long id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}

	@PutMapping(value = "/registers/{id}")
	public ResponseEntity<Register> update(@PathVariable Long id, @RequestBody Register obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}