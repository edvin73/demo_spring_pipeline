package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/hello")
	public String index() {
		return "Welcome to the Home Page!";
	}
	
	@GetMapping("/hello/{name}")
	public String helloWithName(@PathVariable String name) {
		return "Welcome to the Home Page + " + name + "!";
	}

}
