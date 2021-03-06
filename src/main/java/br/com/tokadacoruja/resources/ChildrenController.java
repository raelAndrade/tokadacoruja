package br.com.tokadacoruja.resources;

import java.text.ParseException;
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
import br.com.tokadacoruja.services.ChildrenService;

@Controller
public class ChildrenController {
	
	@Autowired
	private ChildrenRepository childrenRepository;

	@Autowired
	private ChildrenService childrenService;
	
	@Autowired
	private ParentRepository parentRepository;
	
	@GetMapping("/criancas")
	public ModelAndView form(Children children) {
		ModelAndView mv = new ModelAndView("registration/childrens/form");
		List<Parent> parents = parentRepository.findAll();
		mv.addObject("parents", parents);
		mv.addObject("children", children);
		return mv;
	}
	
	@GetMapping("/criancas/listar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("registration/childrens/list");
		mv.addObject("childrens", childrenRepository.findAll());
		return mv;
	}
	
	@PostMapping("/criancas/salvar")
	public ModelAndView save(@Valid Children children, BindingResult result, RedirectAttributes attributes) throws ParseException {
		children.setStatus(true);
		if(result.hasErrors()) {
			return form(children);
		}
		childrenService.save(children);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:/criancas/listar"); 
	}

	@GetMapping("/criancas/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("registration/childrens/form");
		Optional<Children> children = childrenRepository.findById(id);
		List<Parent> parents = parentRepository.findAll();
		mv.addObject("parents", parents);
		mv.addObject("children", children.get());
		return mv;
	}
	
	@GetMapping("/criancas/remover/{id}")
	public ModelAndView remove(@PathVariable Long id){
		Children children = childrenRepository.getOne(id);
		children = childrenRepository.getOne(id);
		children.setStatus(false);
		childrenRepository.save(children);
		ModelAndView mv = new ModelAndView("registration/childrens/list");
		mv.addObject("childrens", childrenRepository.findAll());
		mv.addObject("children", new Children());
		return mv;
	}
	
}
