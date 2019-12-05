package br.com.tokadacoruja.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("registration/childrens/form");
		List<Parent> parents = parentRepository.findAll();
		mv.addObject("parents", parents);
		mv.addObject("children", new Children());
		return mv;
	}
	
	@GetMapping("/criancas/listar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("registration/childrens/list");
		mv.addObject("childrens", childrenRepository.findAll());
		return mv;
	}
	
	@PostMapping("/criancas/salvar")
	public ModelAndView save(@Valid Children children, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return form();
		}
		children.setStatus(true);
		childrenRepository.save(children);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:/criancas/listar"); 
	}
	
	@GetMapping("/criancas/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Children> children = childrenRepository.findById(id);
		ModelAndView mv = new ModelAndView("registration/childrens/form");
		List<Parent> parents = parentRepository.findAll();
		mv.addObject("parents", parents);
		mv.addObject("children", children.get());
		return mv;
	}
	
	
	
	
	
	
	
	/*@GetMapping("/criancas/editar")
	public ModelAndView editForm(Optional<Children> children) {
		ModelAndView mv = new ModelAndView("registration/childrens/edit");
		List<Parent> parents = parentRepository.findAll();
		mv.addObject("parents", parents);
		mv.addObject("children",children);
		return mv;
	}*/
	
	/*@DeleteMapping("/{id}")
	public String remove(@PathVariable Long id) {
		childrenRepository.deleteById(id);		
		return "redirect:/registration/criancas/listar";
	}*/
	
}
