package com.saaiidmoran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saaiidmoran.model.Persona;
import com.saaiidmoran.repo.IPersonaRepo;
import com.saaiidmoran.repo.IUsuarioRepo;

@Service
public class PersonaService {
	
	@Autowired
	IPersonaRepo repoPer;
	
	@Autowired
	IUsuarioRepo repoUsr;
	
	public List<Persona> listarTodas(){
		return repoPer.findAllByOrderByIdpersonaAsc();
	}
	
	public Persona buscarPorId(Integer id){
		return repoPer.findByIdpersona(id);
	}
	
	public Persona buscarPorNombre(String nombre) {
		return repoPer.findByNombre(nombre);
	}
	
	public Persona agregar(Persona p, String nusuario) {
		p.setIdusuario(repoUsr.findByNombre(nusuario));
		return repoPer.save(p);
		
	}
	
	public Persona modificar(Persona p, String nusuario, Integer idpersona) {
		p.setIdpersona(idpersona);
		p.setIdusuario(repoUsr.findByNombre(nusuario));
		return repoPer.save(p);
	}
	
	public void borrar(Integer id) {
		repoPer.deleteById(id);
	}

}
