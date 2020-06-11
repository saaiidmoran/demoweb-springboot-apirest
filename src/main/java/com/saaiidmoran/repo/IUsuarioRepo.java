package com.saaiidmoran.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saaiidmoran.model.Usuario;

/*
 * 
 * Interfaz que extiende la clase JpaRepository, encargada de hacer las
 * operaciones CRUD con la base de datos, en este caso se 
 * especifica que es de la entidad usuario
 * 
 */

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	/*
	 * Especificación del método find by nombre para indicar que también
	 * se puede buscar un usuario por el atributo nombre
	*/
	public Usuario findByNombre(String nombre);
	public Usuario findByIdusuario(Integer idusuario);
	public List<Usuario> findAllByOrderByIdusuario();
	
}
