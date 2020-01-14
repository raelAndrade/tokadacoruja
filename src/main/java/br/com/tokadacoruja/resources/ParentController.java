package br.com.tokadacoruja.resources;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.domain.Parent;
import br.com.tokadacoruja.repositories.ParentRepository;

@Controller
public class ParentController {

	@Autowired
	private ParentRepository parentRepository;
	
	@GetMapping("/pais")
	public ModelAndView form(Parent parent) {
		ModelAndView mv = new ModelAndView("registration/parents/form");
		mv.addObject("parent", parent);
		return mv;
	}
	
	@GetMapping("/pais/listar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("registration/parents/list");
		mv.addObject("parents", parentRepository.findAll());
		return mv;
	}
	
	@PostMapping("/pais/salvar")
	public ModelAndView save(@Valid Parent parent, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return form(parent);
		}
		parent.setStatus(true);
		parentRepository.save(parent);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:/pais/listar"); 
	}
	
	@GetMapping("/pais/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Parent> parent = parentRepository.findById(id);
		ModelAndView mv = new ModelAndView("registration/parents/form");
		mv.addObject("parent", parent.get());
		return mv;
	}
	
	@GetMapping("/pais/remover/{id}")
	public ModelAndView remove(@PathVariable Long id){
		Parent parent = parentRepository.getOne(id);
		parent.setStatus(false);
		parentRepository.save(parent);
		
		ModelAndView mv = new ModelAndView("registration/parents/list");
		mv.addObject("parents", parentRepository.findAll());
		mv.addObject("parent", new Children());
		return mv;
	}
	
}
