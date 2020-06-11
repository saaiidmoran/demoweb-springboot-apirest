package com.saaiidmoran;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.saaiidmoran.model.Usuario;
import com.saaiidmoran.service.UsuarioService;

@SpringBootTest
class DemoWebApplicationTests {
	
	@Autowired
	private UsuarioService serviceUsr;
	
    @Test void crearUsuarioTest() { 
    	Usuario us = new
    	Usuario(); 
    	us.setNombre("saaiidmoran"); 
    	us.setClave("1749");	  
    	Usuario retorno = serviceUsr.agregar(us);
	  
    	assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
  
    }	 
	
	/*
	 * @Test void modificarUsuarioTest() { Usuario us = new Usuario();
	 * us.setNombre("fujita"); us.setClave(encoder.encode("1234")); Usuario retorno
	 * = serviceUsr.modificar(us, 4);
	 * 
	 * assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()) &&
	 * retorno.getNombre().equalsIgnoreCase(us.getNombre())); }
	 * 
	 * @Test void eliminarUsuario() {
	 * 
	 * }
	 */
	

}
