package com.portifolio.tasks.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.portifolio.tasks.entities.Tasks;
import com.portifolio.tasks.services.TasksService;

@RestController
@RequestMapping(value = "/tasks")
public class TasksResource {
	
	@Autowired
	private TasksService service;
	
	@GetMapping
	public ResponseEntity<List<Tasks>> findAll() {
		List<Tasks> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tasks> findById(@PathVariable Long id) {
		Tasks obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Tasks> insert (@RequestBody Tasks obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<Tasks> update(@PathVariable Long id, @RequestBody Tasks obj) {
		obj = service.update(id, obj);		
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value ="/{id}/updated")
	public ResponseEntity<Tasks> updateStatus(@PathVariable Long id, @RequestBody Tasks obj) {
		obj = service.updateStatus(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}