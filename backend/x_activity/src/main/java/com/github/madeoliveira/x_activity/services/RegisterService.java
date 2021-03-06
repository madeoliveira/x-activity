package com.github.madeoliveira.x_activity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.madeoliveira.x_activity.entities.Register;
import com.github.madeoliveira.x_activity.entities.User;
import com.github.madeoliveira.x_activity.repositories.RegisterRepository;
import com.github.madeoliveira.x_activity.repositories.UserRepository;

@Service
public class RegisterService {

	@Autowired
	private RegisterRepository repository;

	@Autowired
	private UserRepository userRepository;

	public List<Register> findAll() {
		return repository.findAll();
	}

	public Register findById(Long id) {
		Optional<Register> obj = repository.findById(id);
		return obj.get();
	}

	public Register insertRegister(Long id, Register reg) {
		User user = userRepository.findById(id).get();
		reg.setClient(user);
		user.setRegister(reg);
		userRepository.save(user);
		return repository.save(reg);
	}

// Implementar 
//	public void delete(Long id) {
//		repository.deleteById(id); 
//	}

	public Register update(Long id, Register obj) {
		Register entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Register entity, Register obj) {
		entity.setRg(obj.getRg());
		entity.setCpf(obj.getCpf());
		entity.setStreet(obj.getStreet());
		entity.setState(obj.getState());
		entity.setCity(obj.getCity());
		entity.setGender(obj.getGender());
		entity.setClient(obj.getClient());
	}

}
