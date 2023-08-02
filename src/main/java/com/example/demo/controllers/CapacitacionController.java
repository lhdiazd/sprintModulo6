package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.CapacitacionService;

@Controller
public class CapacitacionController {
	
	@Autowired
	private CapacitacionService capacitacionService;
	
	@RequestMapping("/listarCapacitaciones")
	public String listarCapacitaciones(Model model) {
		var capacitaciones = capacitacionService.obtenerCapacitaciones();
		model.addAttribute("capacitaciones", capacitaciones);
		
		
		return ("listarCapacitaciones");
	}
	
	
	
}
