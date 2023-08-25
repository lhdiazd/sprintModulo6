package com.example.demo.controllers;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.modelo.PerfilUsuario;
import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.Visita;
import com.example.demo.services.UsuarioService;
import com.example.demo.services.VisitaService;

@Controller
public class VisitaController {
	private Logger log = LogManager.getLogger(VisitaController.class);
	
	@Autowired
	private VisitaService visitaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/crearVisita")
	public String crearVisita(Model model) {
        log.info("Se llamó al método crear visita");
        Visita visita = new Visita();
        model.addAttribute("visita", visita);        
        var usuarios = usuarioService.obtenerUsuarios();            
        model.addAttribute("usuarios", usuarios);
        new Usuario().getPerfilUsuario();
		model.addAttribute("perfilUsuarioCliente", PerfilUsuario.Cliente);
		model.addAttribute("perfilUsuarioProfesional", PerfilUsuario.Profesional);
        return "crearVisita";
    }
	
	@RequestMapping("/listarVisita")
	public String listarVisitas(Model model) {
		log.info("Se llamo al metodo listar visita");
		var visitas = visitaService.obtenerVisitas();
		model.addAttribute("visitas", visitas);		
		return ("listarVisita");
	}
	
	@RequestMapping(value="/crearVisita", method=RequestMethod.POST)
	public String agregarVisita(Visita visita) {
		log.info("Se llamo al metodo agregar visita");
		if(visitaService.crearVisita(visita)) {
			System.out.println("Visita creada con exito");		
			
		}else {
			System.out.println("Creación de Visita fallida");
		}
		return "redirect:/listarVisita";
	}
}
