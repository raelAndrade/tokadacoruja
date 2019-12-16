package br.com.tokadacoruja.resources;

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
	
	@PostMapping("/funcionarios/salvar")
	public ModelAndView save(@Valid Employee employee, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return form(employee);
		}
		employee.setStatus(true);
		employeeRepository.save(employee);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:/funcionarios/listar"); 
	}
	
	@GetMapping("/funcionarios/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		ModelAndView mv = new ModelAndView("registration/employees/form");
		mv.addObject("employee", employee.get());
		return mv;
	}
	
	@GetMapping("/funcionario/remover/{id}")
	public ModelAndView remove(@PathVariable Long id){
		Employee employee = employeeRepository.getOne(id);
		employee.setStatus(false);
		employeeRepository.save(employee);
		
		ModelAndView mv = new ModelAndView("registration/employees/list");
		mv.addObject("employees", employeeRepository.findAll());
		mv.addObject("employee", new Employee());
		return mv;
	}
	
}
