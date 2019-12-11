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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.domain.Schedule;
import br.com.tokadacoruja.domain.enums.Payment;
import br.com.tokadacoruja.repositories.ChildrenRepository;
import br.com.tokadacoruja.repositories.ScheduleRepository;
import br.com.tokadacoruja.services.ScheduleService;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private ChildrenRepository childrenRepository;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/agendas")
	public ModelAndView form(Schedule schedule) {
		ModelAndView mv = new ModelAndView("schedule/form");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("payments", Payment.values());
		mv.addObject("childrens", childrens);
		mv.addObject("schedule", schedule);
		return mv;
	}
	
	@GetMapping("/agendas/listar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("schedule/list");
		mv.addObject("schedules", scheduleRepository.findAll());
		return mv;
	}
	
	@PostMapping("/agendas/salvar")
	public ModelAndView save(@Valid Schedule schedule, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return form(schedule);
		}		
		schedule.setStatus(true);
		scheduleService.save(schedule);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");		
		return new ModelAndView("redirect:/agendas/calendario"); 
	}
	
	@GetMapping("/agendas/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Schedule> schedule = scheduleRepository.findById(id);
		ModelAndView mv = new ModelAndView("schedule/form");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("childrens", childrens);
		mv.addObject("schedule", schedule.get());
		return mv;
	}
	
	@GetMapping("/agendas/remover/{id}")
	public ModelAndView remove(@PathVariable Long id){
		Schedule schedule = scheduleRepository.getOne(id);
		schedule.setStatus(false);
		scheduleRepository.save(schedule);
		
		ModelAndView mv = new ModelAndView("schedule/list");
		mv.addObject("schedules", childrenRepository.findAll());
		mv.addObject("schedule", new Schedule());
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/agendas/list-calendar", method = RequestMethod.GET)
	public List<Schedule> fullCalendar(Schedule schedule) {
		List<Schedule> schedules = scheduleRepository.findAll();
		return schedules;
	}
	
	@GetMapping("/agendas/calendario")
	public ModelAndView getCalendar(Schedule schedule) {
		ModelAndView mv = new ModelAndView("schedule/calendar");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("payments", Payment.values());
		mv.addObject("childrens", childrens);
		mv.addObject("schedule", schedule);
		return mv;
		
	}
	
}
