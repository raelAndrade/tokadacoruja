package br.com.tokadacoruja.resources;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.domain.Schedule;
import br.com.tokadacoruja.repositories.ChildrenRepository;
import br.com.tokadacoruja.repositories.ScheduleRepository;

@Controller
public class BillingController {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private ChildrenRepository childrenRepository;
	
	@GetMapping("/faturamento")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("billings/list");
		
		Optional<Schedule> s = scheduleRepository.findById(1L);
		
		Schedule sch = new Schedule();
		LocalTime dateInitial = sch.getHourInitial();
		//String dateFinal = sch.getHourFinale();
		Long id = sch.getId();
		
		//Schedule schedule = (Schedule) scheduleRepository.buscaCriancaPorDataInicialEDataFinal(dateInitial, dateFinal, id);
		//System.out.println("Total: " + schedule);
		
		return mv;
	}
	
}
