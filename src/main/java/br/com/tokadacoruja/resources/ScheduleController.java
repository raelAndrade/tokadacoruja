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
	public ModelAndView form(Schedule schedule) {
		ModelAndView mv = new ModelAndView("registration/schedule/form");
		List<Children> children = childrenRepository.findAll();
		mv.addObject("payments", Payment.values());
		mv.addObject("children", children);
		mv.addObject(schedule);
		return mv;
	}
	
	@GetMapping("/agendas/listar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("registration/schedule/list");
		mv.addObject("schedule", scheduleRepository.findAll());
		return mv;
	}
	
	@PostMapping("/agendas/salvar")
	public ModelAndView save(@Valid Schedule schedule, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return form(schedule);
		}
		schedule.setStatus(true);
		scheduleRepository.save(schedule);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:/agendas/listar"); 
	}
	
	@GetMapping("/schedule/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Schedule> schedule = scheduleRepository.findById(id);
		ModelAndView mv = new ModelAndView("registration/schedule/edit");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("children", childrens);
		mv.addObject("schedule", schedule.get());
		return mv;
	}
	
	
}
