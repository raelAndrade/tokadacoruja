package br.com.tokadacoruja.resources;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
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
	
	private final DateTimeFormatter FORMAT_HOURS = DateTimeFormatter
			.ofPattern("HH:mm")
			.withResolverStyle(ResolverStyle.STRICT);
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private ChildrenRepository childrenRepository;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/agendamentos/calendario")
	public ModelAndView form(Schedule schedule) {
		ModelAndView mv = new ModelAndView("schedule/calendar");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("payments", Payment.values());
		mv.addObject("childrens", childrens);
		mv.addObject("schedule", schedule);
		return mv;
	}
	
	/*@GetMapping("/agendamentos/calendario")
	public ModelAndView getCalendar(Schedule schedule) {
		ModelAndView mv = new ModelAndView("schedule/calendar");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("payments", Payment.values());
		mv.addObject("childrens", childrens);
		mv.addObject("schedule", schedule);
		return mv;
	}*/
	
	@GetMapping("/agendamentos/listar")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("schedule/list");
		mv.addObject("schedules", scheduleRepository.findAll());
		return mv;
	}
	
	@PostMapping("/agendamentos/salvar")
	public ModelAndView save(@Validated Schedule schedule, BindingResult result, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			return form(schedule);
		}	
		schedule.setStatus(true);
		//schedule.setTotalHours(show(schedule.getHourInitial(), schedule.getHourFinale()));
		
		/*LocalTime entry = schedule.getHourInitial();
		LocalTime out = schedule.getHourFinale();
		Duration duration = Duration.between(entry, out);
		
		schedule.setTotalHours(duration.toHours()+ ":" + duration.toMinutes());*/
    	
		String hour = schedule.getTotalHours().format(formatter);
		String hours[] = hour.split("[.]");

		Long h = Long.parseLong(hours[0]);
		Long m = Long.parseLong(hours[1]);
		
		Double valuePerHours = 0.0;
		Double valuePerMinutes = 0.0;
		Double totalValuePerHours = 0.0;
		
    	if(h < 0 && m <= 59) {
    		valuePerMinutes = schedule.getAmount();
    		schedule.setAmount(valuePerMinutes);
    	}else if(h >= 1 && m != 0) {
    		valuePerHours = h * schedule.getAmount();
    		valuePerMinutes = (schedule.getAmount() / 60.0) * m;
    		totalValuePerHours = valuePerHours + valuePerMinutes;
    		schedule.setAmount(totalValuePerHours);
    	}else if(h >= 1 && m == 0){
    		valuePerHours = h * schedule.getAmount();
    		schedule.setAmount(valuePerHours);
    	}
		scheduleService.save(schedule);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");		
		return new ModelAndView("redirect:/agendamentos/calendario");
	}
	
	/*@GetMapping("/agendamentos/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Schedule> schedule = scheduleRepository.findById(id);
		ModelAndView mv = new ModelAndView("schedule/form");
		List<Children> childrens = childrenRepository.findAll();
		mv.addObject("childrens", childrens);
		mv.addObject("schedule", schedule.get());
		return mv;
	}*/
	
	@GetMapping("/agendamentos/remover/{id}")
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
	@RequestMapping(value = "/agendamentos/list-calendar", method = RequestMethod.GET)
	public List<Schedule> fullCalendar(Schedule schedule) {
		List<Schedule> schedules = scheduleRepository.findAll();
		return schedules;
	}
	
	private LocalTime missing(LocalTime now, LocalTime wish) {
        return wish.minusHours(now.getHour()).minusMinutes(now.getMinute());
    }

    private LocalTime show(LocalTime schedule, String object) {
        LocalTime wish = LocalTime.parse(object, FORMAT_HOURS);
        LocalTime difference = missing(schedule, wish);
        return difference;
    }
    
}
