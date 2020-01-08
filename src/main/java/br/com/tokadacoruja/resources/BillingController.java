package br.com.tokadacoruja.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.domain.Children;
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
		ModelAndView mv = new ModelAndView("billings/form");
		Children children = new Children();
		children.setId(1L);
		Optional<Schedule> schedule = scheduleRepository.findById(children.getId());
		System.out.println("Faturamento: " + schedule);
		//mv.addObject("payments", Payment.values());
		//mv.addObject("childrens", childrens);
		//mv.addObject("schedule", schedule);
		return mv;
	}
}
