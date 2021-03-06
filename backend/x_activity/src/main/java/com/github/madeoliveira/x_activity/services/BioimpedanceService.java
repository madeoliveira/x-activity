package com.github.madeoliveira.x_activity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.madeoliveira.x_activity.entities.Bioimpedance;
import com.github.madeoliveira.x_activity.repositories.BioimpedanceRepository;

@Service
public class BioimpedanceService {

	@Autowired
	private BioimpedanceRepository repository;

	public List<Bioimpedance> findAll() {
		return repository.findAll();
	}

	public Bioimpedance findById(Long id) {
		Optional<Bioimpedance> obj = repository.findById(id);
		return obj.get();
	}

	public Page<Bioimpedance> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	public Bioimpedance insert(Bioimpedance obj) {
		return repository.save(obj);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Bioimpedance update(Long id, Bioimpedance obj) {
		Bioimpedance entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Bioimpedance entity, Bioimpedance obj) {
		entity.setMoment(obj.getMoment());
		entity.setBoneMass(obj.getBoneMass());
		entity.setClient(obj.getClient());
		entity.setFatFreeMass(obj.getFatFreeMass());
		entity.setFatMass(obj.getFatMass());
		entity.setMetabolicAge(obj.getMetabolicAge());
		entity.setPercFat(obj.getPercFat());
		entity.setPercLleanMass(obj.getPercLleanMass());
		entity.setTotBobyWater(obj.getTotBobyWater());
		entity.setVisceralFatIndex(obj.getVisceralFatIndex());
		entity.setClient(obj.getClient());

	}

}
