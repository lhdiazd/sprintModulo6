package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ICapacitacionDao;
import com.example.demo.modelo.Capacitacion;



@Service
public class CapacitacionServiceImpl implements CapacitacionService {
	
	@Autowired
	private ICapacitacionDao iCapacitacionDao;

	@Override
	@Transactional(readOnly=true)
	public List<Capacitacion> obtenerCapacitaciones() {		
		return (List<Capacitacion>) iCapacitacionDao.findAll();
	}

	@Override
	@Transactional
	public boolean crearCapacitacion(Capacitacion capacitacion) {
		try {
			iCapacitacionDao.save(capacitacion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}	
	
}
