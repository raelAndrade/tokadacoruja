package br.com.tokadacoruja.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.repositories.ChildrenRepository;

@Controller
public class ChildrenController {

	@Autowired
	private ChildrenRepository childrenRepository; 
	
	/*@GetMapping("/criancas")
	public String form() {
		return "registration/childrens/form";
	}*/
	
	@GetMapping("/criancas")
	public ModelAndView getForm(Children children) {
		ModelAndView mv = new ModelAndView("registration/childrens/form");
		mv.addObject(children);
		//modelAndView.addObject("tipos", TipoVinho.values());
		return mv;
	}
	
	@GetMapping("/criancas/listar")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("registration/criancas/list");
		mv.addObject("crianca", childrenRepository.findAll());
		return mv;
	}
	
	@PostMapping("/criancas/salvar")
	public ModelAndView  save(@Valid Children children, BindingResult result) {
		if(result.hasErrors()) {
			return getForm(children);
		}
		childrenRepository.save(children);
		return new ModelAndView("redirect:registration/criancas/sucesso"); 
	}
	
	/*@DeleteMapping("/{id}")
	public String remove(@PathVariable Long id) {
		childrenRepository.deleteById(id);		
		return "redirect:/registration/criancas/listar";
	}*/
	
	/*@GetMapping("/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		return getForm(childrenRepository.getOne(id));
	}*/
}
