package com.saaiidmoran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saaiidmoran.model.Usuario;
import com.saaiidmoran.repo.IUsuarioRepo;

@Service//Anotación para indicar que la clase es de servicio
public class UsuarioService {
	
	@Autowired //Inyección de dependencia
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
	
	public void agregarUsrDefault() {
		Usuario u;
		if(buscarPorNombre("root") == null) {
			u = new Usuario();
			u.setNombre("root");
			u.setClave(encoder.encode("12345"));
			if(repoUsr.save(u) == null) {
				System.out.println("El usuario por default del sistema no fué creado correctamente");
			}else {
				System.out.println("El usuario por default del sistema fué creado correctamente\n Usuario: root Contraseña: 12345");
			}
		}else {
			System.out.println("El usuario por default del sistema ya fué creado anteriormente");			
		}
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
