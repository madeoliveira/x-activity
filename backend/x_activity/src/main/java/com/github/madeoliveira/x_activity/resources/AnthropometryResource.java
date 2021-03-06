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

import com.github.madeoliveira.x_activity.entities.Anthropometry;
import com.github.madeoliveira.x_activity.services.AnthropometryService;

@RestController
@RequestMapping(value = "/api")
public class AnthropometryResource {

	@Autowired
	private AnthropometryService service;

	@GetMapping(value = "/anthropometrys")
	public ResponseEntity<List<Anthropometry>> findAll() {
		List<Anthropometry> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/anthropometrys/page")
	public ResponseEntity<Page<Anthropometry>> findAll(Pageable pageable) {
		Page<Anthropometry> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/anthropometrys/{id}")
	public ResponseEntity<Anthropometry> findBuId(@PathVariable Long id) {
		Anthropometry obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping(value = "/anthropometrys")
	public ResponseEntity<Anthropometry> insert(@RequestBody @Valid Anthropometry obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/anthropometrys/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/anthropometrys/{id}")
	public ResponseEntity<Anthropometry> update(@PathVariable Long id, @RequestBody @Valid Anthropometry obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}