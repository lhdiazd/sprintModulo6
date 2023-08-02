package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactoController {
	
	@RequestMapping("/contacto")
	public String contacto() {		
		return ("contacto");
	}
	
}
