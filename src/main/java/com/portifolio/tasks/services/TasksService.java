package com.portifolio.tasks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portifolio.tasks.entities.Tasks;
import com.portifolio.tasks.repositories.TasksRepository;

@Service
public class TasksService {

	@Autowired
	private TasksRepository repository;
	
	
	public List<Tasks> findAll() {
		return repository.findAll();
	}
	
	public Tasks findById(Long id) {
		Optional<Tasks> obj = repository.findById(id);
		return obj.get();
	}
	
	public Tasks insert(Tasks obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Tasks update(Long id, Tasks obj) {
		Tasks entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	public Tasks updateStatus(Long id, Tasks obj) {
		Tasks entity = repository.getReferenceById(id);
		updateStatus(entity, obj);
		return repository.save(entity);
	}

	private void updateStatus(Tasks entity, Tasks obj) {
		entity.setStatus(obj.getStatus());
	}

	private void updateData(Tasks entity, Tasks obj) {
		
		if (obj.getTitle() != null) {
			entity.setTitle(obj.getTitle());
		}
		
		if (obj.getDescription() != null) {
			entity.setDescription(obj.getDescription());
		}
	}
}

