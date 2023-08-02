package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	
	@RequestMapping({"/", "/inicio"})
	public String inicio() {
		
		return ("inicio");
	}

}
