package br.com.tokadacoruja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.repositories.ChildrenRepository;
import br.com.tokadacoruja.repositories.ScheduleRepository;

@Controller
public class IndexController {
	

	@Autowired
	private ChildrenRepository childrenRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("children", childrenRepository.count());
		mv.addObject("schedule", scheduleRepository.count());
		return mv;
	}

}
