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

import com.github.madeoliveira.x_activity.entities.Bioimpedance;
import com.github.madeoliveira.x_activity.services.BioimpedanceService;

@RestController
@RequestMapping(value = "/api")
public class BioimpedanceResource {

	@Autowired
	private BioimpedanceService service;

	@GetMapping(value = "/bioimpedances")
	public ResponseEntity<List<Bioimpedance>> findAll() {
		List<Bioimpedance> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/bioimpedances/page")
	public ResponseEntity<Page<Bioimpedance>> findAll(Pageable pageable) {
		Page<Bioimpedance> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/bioimpedances/{id}")
	public ResponseEntity<Bioimpedance> findBuId(@PathVariable Long id) {
		Bioimpedance obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping(value = "/bioimpedances")
	public ResponseEntity<Bioimpedance> insert(@RequestBody @Valid Bioimpedance obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/bioimpedances/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/bioimpedances/{id}")
	public ResponseEntity<Bioimpedance> update(@PathVariable Long id, @RequestBody @Valid Bioimpedance obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}