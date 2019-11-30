package br.com.tokadacoruja.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.domain.Parent;
import br.com.tokadacoruja.repositories.ParentRepository;

@Controller
public class ParentController {

	@Autowired
	private ParentRepository parentRepository;
	
	@GetMapping("/pais")
	public ModelAndView getForm(Parent parent) {
		ModelAndView mv = new ModelAndView("registration/parents/form");
		mv.addObject(parent);
		//modelAndView.addObject("tipos", TipoVinho.values());
		return mv;
	}
	
	@GetMapping("/pais/listar")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("registration/parents/list");
		mv.addObject("pais", parentRepository.findAll());
		return mv;
	}
	
	@PostMapping("/pais/salvar")
	public ModelAndView save(@Valid Parent parent, BindingResult result) {
		if(result.hasErrors()) {
			return getForm(parent);
		}
		parent.setStatus(true);
		parentRepository.save(parent);		
		return new ModelAndView("redirect:registration/parents/sucesso"); 
	}
	
	/*@DeleteMapping("/{id}")
	public String remove(@PathVariable Long id) {
		parentRepository.deleteById(id);		
		return "redirect:/registration/parents/listar";
	}*/
	
	/*@GetMapping("/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		return getForm(parentRepository.getOne(id));
	}*/
	
}
