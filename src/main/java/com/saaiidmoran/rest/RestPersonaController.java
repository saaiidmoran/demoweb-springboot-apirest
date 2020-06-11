package com.saaiidmoran.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saaiidmoran.model.Persona;
import com.saaiidmoran.service.PersonaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/personasREST") 
public class RestPersonaController {
	
	@Autowired
	private PersonaService servicePer;
	
	@GetMapping
	public List<Persona> listar(){
		return servicePer.listarTodas();
	}
	
	@GetMapping(value = "/buscarPorId/{idpersona}")
	public Persona buscarPorId(@PathVariable("idpersona")Integer id){		
		return servicePer.buscarPorId(id);		
	}
	
	@GetMapping(value = "/buscarPorNombre/{nombre}")
	public Persona buscarPorNombre(@PathVariable("nombre") String nombre) {
		return servicePer.buscarPorNombre(nombre);
	}
	
	@PostMapping(value = "/{nusuario}")
	public Persona insertar(@RequestBody Persona p, @PathVariable("nusuario") String nusuario) {
		return servicePer.agregar(p, nusuario);
	}
	
	@PutMapping(value = "/{idpersona}/{nusuario}")
	public Persona modificar(@RequestBody Persona p, @PathVariable("nusuario") String nusuario, @PathVariable("idpersona") Integer idpersona) {
		return servicePer.modificar(p, nusuario, idpersona);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar (@PathVariable("id") Integer id) {
		servicePer.borrar(id);
	}
	
}
