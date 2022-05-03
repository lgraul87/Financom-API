package com.example.restservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.restservice.model.User;
import com.example.restservice.repository.UserRepository;

@RestController
public class GreetingController {

	@Autowired
	UserRepository rp;

	@GetMapping("/users")
	public List<User> findAll() {
		if (rp.findAll().size() == 0) {
			User raul = new User(1, "raul");
			rp.save(raul);
		}

		return rp.findAll();
	}
}
