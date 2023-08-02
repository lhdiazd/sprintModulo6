package com.example.demo.services;

import java.util.List;

import com.example.demo.modelo.Capacitacion;


public interface CapacitacionService {
	public List<Capacitacion> obtenerCapacitaciones();	
	public void crearCapacitacion(Capacitacion capacitacion);
}
