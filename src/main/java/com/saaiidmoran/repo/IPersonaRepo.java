package com.saaiidmoran.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saaiidmoran.model.Persona;

/*
 * 
 * Interfaz que extiende la clase JpaRepository, encargada de hacer las
 * operaciones CRUD con la base de datos, en este caso se 
 * especifica que es de la entidad persona
 * 
 */

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{
	public List<Persona> findAllByOrderByIdpersonaAsc();
	public Persona findByIdpersona(Integer idpersona);
	public Persona findByNombre(String nombre);
}
