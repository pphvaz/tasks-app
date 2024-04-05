package com.portifolio.tasks.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portifolio.tasks.entities.Tasks;

@RestController
@RequestMapping(value = "/tasks")
public class TasksResource {
	
	@GetMapping
	public ResponseEntity<Tasks> findAll() {
		Tasks t = new Tasks((long) 1, "Do the laundry", "Split white and black shirts");
		return ResponseEntity.ok().body(t);
	}
}
