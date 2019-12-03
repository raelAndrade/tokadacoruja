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
import br.com.tokadacoruja.domain.enums.Payment;
import br.com.tokadacoruja.repositories.ChildrenRepository;
import br.com.tokadacoruja.repositories.ScheduleRepository;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private ChildrenRepository childrenRepository;
	
	@GetMapping("/agendas")
	public ModelAndView getForm(Schedule schedule) {
		ModelAndView mv = new ModelAndView("registration/schedule/form");
		List<Children> children = childrenRepository.findAll();

		mv.addObject("payments", Payment.values());
		mv.addObject("children", children);
		mv.addObject("schedule", schedule);
		return mv;
	}
	
	@GetMapping("/agendas/listar")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("registration/schedule/list");
		mv.addObject("schedule", scheduleRepository.findAll());
		return mv;
	}
	
	@PostMapping("/agendas/salvar")
	public ModelAndView save(@Valid Schedule schedule, BindingResult result) {
		if(result.hasErrors()) {
			return getForm(schedule);
		}
		scheduleRepository.save(schedule);
		return new ModelAndView("redirect:/agendas/listar"); 
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
