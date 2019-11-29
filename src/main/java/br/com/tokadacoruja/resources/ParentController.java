package br.com.tokadacoruja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.repositories.ParentRepository;

@Controller
public class ParentController {

	@Autowired
	private ParentRepository parentRepository;
	
	@GetMapping("/pais")
	public String form() {
		return "registration/parents/form";
	}
	
	@GetMapping("/pais/listar")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("registration/parents/list");
		return mv;
	}
}
