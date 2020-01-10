package br.com.tokadacoruja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("billings/list");
		//Schedule schedule = (Schedule) scheduleRepository.buscaCriancaPorDataInicialEDataFinal(dateInitial, dateFinal, id);
		//System.out.println("Total: " + schedule);
		return mv;
	}
	
	@PostMapping("/faturamento/{id}/{dateInitial}/{dateFinal}")
	public ModelAndView filterPerData(@Param("id") Long id, @Param("dateInitial") String dateInitial, @Param("dateFinal") String dateFinal) {
		ModelAndView mv = new ModelAndView("billings/list");
		
		//Schedule schedule = (Schedule) scheduleRepository.buscaCriancaPorDataInicialEDataFinal(dateInitial, dateFinal, id);
		//System.out.println("Total: " + schedule);
		
		return mv;
	}
	
}
