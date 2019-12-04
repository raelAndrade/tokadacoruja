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
import br.com.tokadacoruja.service.ChildrenService;

@Controller
public class ChildrenController {

	@Autowired
	private ChildrenService childrenService;
	
	@Autowired
	private ChildrenRepository childrenRepository;
	
	@Autowired
	private ParentRepository parentRepository;
	
	@GetMapping("/criancas")
	public ModelAndView form(Optional<Children> children) {
		ModelAndView mv = new ModelAndView("registration/childrens/form");
		List<Parent> parents = parentRepository.findAll();
		mv.addObject("parents", parents);
		mv.addObject("children",children);
		return mv;
	}
	
	@GetMapping("/criancas/listar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("registration/childrens/list");
		mv.addObject("childrens", childrenService.findAll());
		return mv;
	}
	
	@GetMapping("/crianca/adicionar")
	public ModelAndView add(Children children) {
		
		ModelAndView mv = new ModelAndView("registration/childrens/form");
		mv.addObject("children", children);
		
		return mv;
	}
	
	@PostMapping("/criancas/salvar")
	public ModelAndView save(@Valid Children children, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return add(children);
		}
		children.setStatus(true);
		childrenService.save(children);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:/criancas/listar"); 
	}
	

	@GetMapping("/criancas/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Children children = childrenRepository.getOne(id);
		mv.addObject("children", children);
		mv.setViewName("/criancas/editar");
		return mv;
	}
	
	@PostMapping("/criancas/editar")
	public ModelAndView edit(@Valid Children children, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("/criancas/editar");
			mv.addObject(children);
		}else {
			mv.setViewName("redirect:/registration/childrens/list");
			childrenService.save(children);
		}
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
