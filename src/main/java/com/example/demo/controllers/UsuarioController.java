package com.example.demo.controllers;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.PerfilUsuario;
import com.example.demo.modelo.Usuario;
import com.example.demo.services.UsuarioService;

@Controller
public class UsuarioController {
	
	private Logger log = LogManager.getLogger(UsuarioController.class);
		
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/crearUsuario")
	public String crearUsuario(Model model) {
		log.info("Se llamo al metodo crear Usuario");		
		var usuarios = usuarioService.obtenerUsuarios();                
        model.addAttribute("usuarios", usuarios);
        return "crearUsuario";
	}
	
	@RequestMapping("/listarUsuario")
	public String listarUsuarios(Model model) {
		log.info("Se llamo al metodo listar usuarios");
		var usuarios = usuarioService.obtenerUsuarios();
		model.addAttribute("usuarios", usuarios);		
		return ("listarUsuario");
	}
	
	@RequestMapping(value="/crearUsuario", method=RequestMethod.POST)
	public String agregarUsuario(@RequestParam("nombre") String nombre,
	                             @RequestParam("perfilUsuario") String perfilUsuarioString) {
	    log.info("Se llamó al método agregar usuario");

	    try {
	        PerfilUsuario perfilUsuario = PerfilUsuario.valueOf(perfilUsuarioString);

	        Usuario usuario = new Usuario();
	        usuario.setNombre(nombre);
	        usuario.setPerfilUsuario(perfilUsuario);

	        if(usuarioService.crearUsuario(usuario)) {
	            System.out.println("Usuario creado con éxito");            
	            System.out.println("ID usuario: " + usuario.getId() + "\n" + "Nombre usuario: "
	                    + usuario.getNombre() + "\n" + "Tipo: " + usuario.getPerfilUsuario());
	        } else {
	            System.out.println("Creación fallida");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Valor de perfilUsuario inválido");
	    }

	    return "redirect:/listarUsuario";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String editarUsuario(@PathVariable int id, Model model) {
	    Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
	    model.addAttribute("usuario", usuario);
	    return "editarUsuario";
	}
	
	@PostMapping("/editarUsuario")
	public String procesarEdicion(@ModelAttribute Usuario usuario) {
	    if (usuarioService.actualizarUsuario(usuario)) {
	        return "redirect:/listarUsuario";
	    } else {	        
	        return "error";
	    }
	}



}
