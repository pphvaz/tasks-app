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
}

