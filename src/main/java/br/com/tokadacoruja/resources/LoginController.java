package br.com.tokadacoruja.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("/login/login");
//		mv.addObject("mensagem", "Mensagem do controller");
		return mv;
	}
}
