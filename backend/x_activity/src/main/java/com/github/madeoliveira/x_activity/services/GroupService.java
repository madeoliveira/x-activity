package com.github.madeoliveira.x_activity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.madeoliveira.x_activity.entities.Group;
import com.github.madeoliveira.x_activity.repositories.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository repository;

	public List<Group> findAll() {
		return repository.findAll();
	}

	public Group findById(Long id) {
		Optional<Group> obj = repository.findById(id);
		return obj.get();
	}

	public Group insert(Group obj) {
		return repository.save(obj);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Group update(Long id, Group obj) {
		Group entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Group entity, Group obj) {
		entity.setName(obj.getName());
	}
}
