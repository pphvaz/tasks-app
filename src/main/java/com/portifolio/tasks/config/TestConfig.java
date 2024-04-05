package com.portifolio.tasks.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.portifolio.tasks.entities.Tasks;
import com.portifolio.tasks.repositories.TasksRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private TasksRepository tasksRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Tasks t1 = new Tasks(null, "Do the laundry", "Split black and white clothes");
		Tasks t2 = new Tasks(null, "Prepare meeting", "At 16:00");
		
		tasksRepository.saveAll(Arrays.asList(t1, t2));
		
	}
	
	
}
