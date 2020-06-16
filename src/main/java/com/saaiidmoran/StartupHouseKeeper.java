package com.saaiidmoran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.saaiidmoran.service.UsuarioService;

@Component//Anotación component (Indica que se ejecutará antes de la ejecución) 
public class StartupHouseKeeper {
	
	@Autowired//Anotación para inyección de dependencia, de esta forma no es necesario incializar el objeto
	private UsuarioService us;
	
	@EventListener(ApplicationReadyEvent.class)//Evento para reaccionar cuando la aplicación esté lista
	public void realizarRegistrosPrevios() {
		us.agregarUsrDefault();
	}

}
