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
import br.com.tokadacoruja.domain.Schedule;
import br.com.tokadacoruja.repositories.ChildrenRepository;
import br.com.tokadacoruja.repositories.ScheduleRepository;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private ChildrenRepository childrenRepository;
	
	/*@GetMapping("/criancas")
	public String form() {
		return "registration/childrens/form";
	}*/
	
	@GetMapping("/agendas")
	public ModelAndView getForm(Schedule schedule) {
		ModelAndView mv = new ModelAndView("registration/schedule/form");
		List<Children> children = childrenRepository.findAll();

		mv.addObject("schedule", schedule);
		mv.addObject(children);
		return mv;
	}
	
	@GetMapping("/criancas/listar")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("registration/childrens/list");
		mv.addObject("childrens", childrenRepository.findAll());
		return mv;
	}
	
	@PostMapping("/criancas/salvar")
	public ModelAndView save(@Valid Schedule schedule, BindingResult result) {
		if(result.hasErrors()) {
			return getForm(schedule);
		}
		scheduleRepository.save(schedule);
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
