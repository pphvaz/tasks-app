package com.portifolio.tasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portifolio.tasks.entities.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long> {
	
}
