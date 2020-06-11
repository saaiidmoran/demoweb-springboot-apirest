package com.saaiidmoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saaiidmoran.model.Persona;
import com.saaiidmoran.repo.IPersonaRepo;

//Especificación al Spring container de que esto es un controlador
@Controller
public class DemoController {
	
	//Inyección de dependencia
	@Autowired
	private IPersonaRepo repo;
	
	//Especificación de lo que se hará en el metodo get, se espeficica un valor agregarPersona en la ruta
	@GetMapping("/agregarPersona")
    public String agregarPersona(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        
		//Esto debería de ir en un paquete llamado Service
		Persona p = new Persona();
        p.setIdpersona(2);
        p.setNombre("Isaac");
		repo.save(p);
		
		//Se agrega al modelo la variable name
		model.addAttribute("name", name);
		
		//SE retorna el nombre del documentp html ubicado en resources
        return "greeting";
    }
	//MEtodo get con el valor listar en la ruta
	@GetMapping("/listar")
    public String greeting(Model model) {
		model.addAttribute("personas", repo.findAll());
        return "greeting";
    }

}
