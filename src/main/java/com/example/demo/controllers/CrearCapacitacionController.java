package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrearCapacitacionController {
	
	@RequestMapping("/crearCapacitacion")
	public String crearCapacitacion() {
		
		return ("crearCapacitacion");
	}

}
