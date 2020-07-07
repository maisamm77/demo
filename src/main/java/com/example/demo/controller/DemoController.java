package com.example.demo.controller;

import com.example.demo.annotation.ReturnStringInstead;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello";
	}

	@GetMapping("/test")
	@ReturnStringInstead(name = "new Test")
	public String sayHelloTest() {
		return "Hello Test";
	}
}
