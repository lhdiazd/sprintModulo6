package com.example.demo.services;

import java.util.List;


import com.example.demo.modelo.Usuario;


public interface UsuarioService {
	public List<Usuario> obtenerUsuarios();	
	public boolean crearUsuario(Usuario usuario);
	public Usuario obtenerUsuarioPorId(int id);
	public boolean actualizarUsuario(Usuario usuario);
}
