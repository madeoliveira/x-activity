package com.github.madeoliveira.x_activity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.madeoliveira.x_activity.entities.Anthropometry;
import com.github.madeoliveira.x_activity.repositories.AnthropometryRepository;

@Service
public class AnthropometryService {

	@Autowired
	private AnthropometryRepository repository;

	public List<Anthropometry> findAll() {
		return repository.findAll();
	}
	public Page<Anthropometry> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Anthropometry findById(Long id) {
		Optional<Anthropometry> obj = repository.findById(id);
		return obj.get();
	}

	public Anthropometry insert(Anthropometry obj) {
		return repository.save(obj);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Anthropometry update(Long id, Anthropometry obj) {
		Anthropometry entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Anthropometry entity, Anthropometry obj) {
		entity.setMoment(obj.getMoment());
		entity.setAbdminalFold(obj.getAbdminalFold());
		entity.setTricepsFold(obj.getTricepsFold());
		entity.setAbdomenCircumf(obj.getAbdomenCircumf());
		entity.setBicipitalFold(obj.getBicipitalFold());
		entity.setCalfCircumf(obj.getCalfCircumf());
		entity.setCalfFold(obj.getCalfFold());
		entity.setHandleDiameter(obj.getHandleDiameter());
		entity.setHipCircumf(obj.getHipCircumf());
		entity.setMiddleAxillaryFold(obj.getMiddleAxillaryFold());
		entity.setNeckCircumf(obj.getNeckCircumf());
		entity.setRelaxedArmCircumf(obj.getRelaxedArmCircumf());
		entity.setSubscapularFold(obj.getSubscapularFold());
		entity.setSuprailacFold(obj.getSuprailacFold());
		entity.setThighFold(obj.getThighFold());
		entity.setThighmedialCircumf(obj.getThighmedialCircumf());
		entity.setWaistCircumf(obj.getWaistCircumf());
		entity.setClient(obj.getClient());

	}

}
