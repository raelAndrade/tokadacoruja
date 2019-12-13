package br.com.tokadacoruja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.domain.Employee;
import br.com.tokadacoruja.repositories.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/funcionarios")
	public ModelAndView form(Employee employee) {
		ModelAndView mv = new ModelAndView("registration/employees/form");
		mv.addObject("employee", employee);
		return mv;
	}
	
	@GetMapping("/funcionarios/listar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("registration/employees/list");
		mv.addObject("employees", employeeRepository.findAll());
		return mv;
	}
	
//	@PostMapping("/criancas/salvar")
//	public ModelAndView save(@Valid Children children, BindingResult result, RedirectAttributes attributes) throws ParseException {
//		if(result.hasErrors()) {
//			return form(children);
//		}
//		children.setStatus(true);
//		childrenService.save(children);
//		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
//		return new ModelAndView("redirect:/criancas/listar"); 
//	}
	
//	@GetMapping("/criancas/editar/{id}")
//	public ModelAndView edit(@PathVariable("id") Long id) {
//		Optional<Children> children = childrenRepository.findById(id);
//		ModelAndView mv = new ModelAndView("registration/childrens/form");
//		List<Parent> parents = parentRepository.findAll();
//		mv.addObject("parents", parents);
//		mv.addObject("children", children.get());
//		return mv;
//	}
	
//	@GetMapping("/criancas/remover/{id}")
//	public ModelAndView remove(@PathVariable Long id){
//		Children children = childrenRepository.getOne(id);
//		children.setStatus(false);
//		childrenRepository.save(children);
//		
//		ModelAndView mv = new ModelAndView("registration/childrens/list");
//		mv.addObject("childrens", childrenRepository.findAll());
//		mv.addObject("children", new Children());
//		return mv;
//	}
	
}
