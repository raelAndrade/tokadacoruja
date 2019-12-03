package br.com.tokadacoruja.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	@GetMapping("/criancas")
	public ModelAndView getForm(Children children) {
		ModelAndView mv = new ModelAndView("registration/childrens/form");
		List<Parent> parents = parentRepository.findAll();
		mv.addObject("parents", parents);
		mv.addObject("children", children);
		return mv;
	}
	
	@GetMapping("/criancas/listar")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("registration/childrens/list");
		mv.addObject("childrens", childrenRepository.findAll());
		return mv;
	}
	
	@PostMapping("/criancas/salvar")
	public ModelAndView save(@Valid Children children, BindingResult result) {
		if(result.hasErrors()) {
			return getForm(children);
		}
		children.setStatus(true);
		childrenRepository.save(children);
		return new ModelAndView("redirect:/criancas/listar"); 
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
