package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

	@RequestMapping("/")
	public String hello(){
		return "Hello World";
	}

	@RequestMapping("/protected")
	public String protectedHello(){
		return "Hello World, i was protected";
	}

	@RequestMapping("/admin")
	public String admin(){
		return "Hello World from admin";
	}

}
