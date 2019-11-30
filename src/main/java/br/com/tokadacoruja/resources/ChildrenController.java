package br.com.tokadacoruja.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.domain.Parent;
import br.com.tokadacoruja.repositories.ChildrenRepository;
import br.com.tokadacoruja.repositories.ParentRepository;

@Controller
public class ChildrenController {

	@Autowired
	private ChildrenRepository childrenRepository;
	
	@Autowired
	private ParentRepository parentRepository;
	
	/*@GetMapping("/criancas")
	public String form() {
		return "registration/childrens/form";
	}*/
	
	@GetMapping("/criancas")
	public ModelAndView getForm(Children children) {
		ModelAndView mv = new ModelAndView("registration/childrens/form");
		List<Parent> parents = parentRepository.findAll();
		
		System.out.println("Pais: " + parents);
		mv.addObject("parents", parents);
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
	public ModelAndView save(Children children) {
		children.setStatus(true);
		childrenRepository.save(children);
		return new ModelAndView("redirect:registration/childrens/sucesso"); 
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
