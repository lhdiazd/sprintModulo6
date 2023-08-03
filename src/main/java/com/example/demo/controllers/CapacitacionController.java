package com.example.demo.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.modelo.Capacitacion;
import com.example.demo.services.CapacitacionService;

@Controller
public class CapacitacionController {
	
	private Logger log = LogManager.getLogger(CapacitacionController.class);
		
	@Autowired
	private CapacitacionService capacitacionService;
	
	@RequestMapping("/crearCapacitacion")
	public String crearCapacitacion(Model model) {
		log.info("Se llamo al metodo crear capacitacion");
		Capacitacion capacitacion = new Capacitacion();
		model.addAttribute("capacitacion", capacitacion);		
		return ("crearCapacitacion");
	}
	
	@RequestMapping("/listarCapacitaciones")
	public String listarCapacitaciones(Model model) {
		log.info("Se llamo al metodo listar capacitacion");
		var capacitaciones = capacitacionService.obtenerCapacitaciones();
		model.addAttribute("capacitaciones", capacitaciones);		
		return ("listarCapacitaciones");
	}
	
	@RequestMapping(value="/crearCapacitacion", method=RequestMethod.POST)
	public String agregarCapacitacion(Capacitacion capacitacion) {
		log.info("Se llamo al metodo agregar capacitacion");
		if(capacitacionService.crearCapacitacion(capacitacion)) {
			System.out.println("Capacitación creada con exito");			
			System.out.println("ID ca"
					+ "pacitación: " + capacitacion.getId() + "\n" + "Nombre capacitacion: "
					+ capacitacion.getNombre() + "\n" + "Detalle: " + capacitacion.getDetalle());
		}else {
			System.out.println("Creación fallida");
		}
		return "redirect:/listarCapacitaciones";
	}
	
}
