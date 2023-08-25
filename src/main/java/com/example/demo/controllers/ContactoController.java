package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactoController {
	
	@RequestMapping("/contacto")
	public String contacto() {		
		return ("contacto");
	}
	
	@PostMapping("/contacto")
	public String procesarContacto(@RequestParam String nombre, @RequestParam String correo, @RequestParam String mensaje) {
	    System.out.println("Nombre de contacto: " + nombre);
	    System.out.println("Correo de contacto: " + correo);
	    System.out.println("Mensaje de contacto: " + mensaje);
	    return "redirect:/contacto";
	}
	
}
