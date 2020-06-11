package com.saaiidmoran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saaiidmoran.model.Usuario;
import com.saaiidmoran.repo.IUsuarioRepo;

@Service
public class UsuarioService {
	
	@Autowired
	IUsuarioRepo repoUsr;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public List<Usuario> listarTodos(){
		return repoUsr.findAllByOrderByIdusuario();
	}
	
	public Usuario buscarPorId(Integer id) {
		return repoUsr.findByIdusuario(id);
	}
	
	public Usuario buscarPorNombre(String nombre) {
		return repoUsr.findByNombre(nombre);
	}
	
	public Usuario agregar(Usuario u) {
		u.setClave(encoder.encode(u.getClave()));
		return repoUsr.save(u);
	}
	
	public Usuario modificar(Usuario u, Integer id) {
		u.setIdusuario(id);
		u.setClave(encoder.encode(u.getClave()));
		return repoUsr.save(u);
	}
	
	public void borrar(Integer id) {
		repoUsr.deleteById(id);
	}
	
}
