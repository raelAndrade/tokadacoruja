package br.com.tokadacoruja.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.domain.Schedule;
import br.com.tokadacoruja.repositories.ChildrenRepository;
import br.com.tokadacoruja.repositories.ScheduleRepository;

@Controller
public class BillingController {

	@SuppressWarnings("unused")
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@SuppressWarnings("unused")
	@Autowired
	private ChildrenRepository childrenRepository;
	
	@GetMapping("/faturamento")
	public ModelAndView form(Schedule schedule) {
		ModelAndView mv = new ModelAndView("billings/list");
		
		//Schedule schedule = (Schedule) scheduleRepository.buscaCriancaPorDataInicialEDataFinal(dateInitial, dateFinal, id);
		//System.out.println("Total: " + schedule);
		
		return mv;
	}
	
	/*@PostMapping("/faturamento/{id}/{dateInitial}/{dateFinal}")
	public ModelAndView filterPerData(@Param("id") Long id, @Param("dateInitial") String dateInitial, @Param("dateFinal") String dateFinal) {
		ModelAndView mv = new ModelAndView("billings/list");		
		//Schedule schedule = (Schedule) scheduleRepository.buscaCriancaPorDataInicialEDataFinal(dateInitial, dateFinal, id);
		//System.out.println("Total: " + schedule);		
		return mv;
	}*/
	
	@RequestMapping(value="/search")
	public String Search(Schedule schedule, BindingResult result, @RequestParam("id") Long id, @RequestParam("dateInitial") String dateInitial, @RequestParam("dateFinal") String dateFinal) {
		
		System.out.println(scheduleRepository.buscaCriancaPorDataInicialEDataFinal(dateInitial, dateFinal, id));
		
	    return "search";
	}
	
}
