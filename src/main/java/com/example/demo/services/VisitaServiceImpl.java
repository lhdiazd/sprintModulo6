package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IVisitaDao;
import com.example.demo.modelo.Visita;

@Service
public class VisitaServiceImpl implements VisitaService {
	
	@Autowired
	private IVisitaDao iVisitaDao;

	@Override
	@Transactional(readOnly=true)
	public List<Visita> obtenerVisitas() {
		return (List<Visita>) iVisitaDao.findAll();	
	}

	@Override
	@Transactional
	public boolean crearVisita(Visita visita) {
		try {
			iVisitaDao.save(visita);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		
	}
}
