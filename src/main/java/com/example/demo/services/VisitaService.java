package com.example.demo.services;

import java.util.List;

import com.example.demo.modelo.Visita;

public interface VisitaService {
	public List<Visita> obtenerVisitas();
	public boolean crearVisita(Visita visita);
}
