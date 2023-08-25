package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IUsuarioDao;

import com.example.demo.modelo.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private IUsuarioDao iUsuarioDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> obtenerUsuarios() {
		
		return (List<Usuario>) iUsuarioDao.findAll();
	}

	
	@Override
	@Transactional
	public boolean crearUsuario(Usuario usuario) {
		try {
			iUsuarioDao.save(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
	
	@Override
	public Usuario obtenerUsuarioPorId(int id) {
	    return iUsuarioDao.findById(id).orElse(null);
	    
	}
	
	@Override
	@Transactional
	public boolean actualizarUsuario(Usuario usuario) {
	    try {
	        iUsuarioDao.save(usuario);
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
