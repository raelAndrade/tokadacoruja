package br.com.tokadacoruja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.repositories.DailyRepository;

@Controller
public class DailyController {
	
	@SuppressWarnings("unused")
	@Autowired
	private DailyRepository dailyRepository;
	
	@GetMapping("/agenda/cadastrar")
	public ModelAndView form() {
		final ModelAndView mv = new ModelAndView("daily/form");
		return mv;
	}

}
