package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Visita;


@Repository
public interface IVisitaDao extends CrudRepository<Visita, Integer> {

}
