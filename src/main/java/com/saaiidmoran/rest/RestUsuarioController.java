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

import com.saaiidmoran.model.Usuario;
import com.saaiidmoran.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/usuariosREST")
public class RestUsuarioController {
	
	@Autowired
	private  UsuarioService serviceUsr;
	
	@GetMapping
	public List<Usuario> listar(){
		return serviceUsr.listarTodos();
	}
	
	@GetMapping(value = "/buscarPorId/{idusr}")
	public Usuario buscarPorId(@PathVariable ("idusr") Integer id) {
		return serviceUsr.buscarPorId(id);
	}
	
	@GetMapping(value = "/buscarPorNombre/{nombre}")
	public Usuario buscarPorNombre(@PathVariable("nombre") String nombre) {
		return serviceUsr.buscarPorNombre(nombre);
	}
	
	@PostMapping
	public void insertar(@RequestBody Usuario usr) {
		serviceUsr.agregar(usr);
	}
	
	@PutMapping(value = "/{id}")
	public Usuario modificar(@RequestBody Usuario usr, @PathVariable("id") Integer id) {
		return serviceUsr.modificar(usr,id);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public void eliminar (@PathVariable("id") Integer id) {
		serviceUsr.borrar(id);
	}

}
