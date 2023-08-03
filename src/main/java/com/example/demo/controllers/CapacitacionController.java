package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.modelo.Capacitacion;
import com.example.demo.services.CapacitacionService;

@Controller
public class CapacitacionController {
	
	@Autowired
	private CapacitacionService capacitacionService;
	
	@RequestMapping("/crearCapacitacion")
	public String crearCapacitacion(Model model) {
		Capacitacion capacitacion = new Capacitacion();
		model.addAttribute("capacitacion", capacitacion);		
		return ("crearCapacitacion");
	}
	
	@RequestMapping("/listarCapacitaciones")
	public String listarCapacitaciones(Model model) {
		var capacitaciones = capacitacionService.obtenerCapacitaciones();
		model.addAttribute("capacitaciones", capacitaciones);		
		return ("listarCapacitaciones");
	}
	
	@RequestMapping(value="/crearCapacitacion", method=RequestMethod.POST)
	public String agregarCapacitacion(Capacitacion capacitacion) {
		capacitacionService.crearCapacitacion(capacitacion);		
		return "redirect:/listarCapacitaciones";
	}
	
}
