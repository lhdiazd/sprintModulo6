package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Capacitacion;
import com.example.demo.services.CapacitacionService;

@Controller
public class CrearCapacitacionController {
	
	@Autowired
	private CapacitacionService capacitacionService;	
	
	@RequestMapping("/crearCapacitacion")
	public String crearCapacitacion() {
		
		return ("crearCapacitacion");
	}
	
	@PostMapping("/save")
	public String agregarCapacitacion(Capacitacion capacitacion) {
		capacitacionService.crearCapacitacion(capacitacion);
		
		return "redirect:/inicio";
	}

}
