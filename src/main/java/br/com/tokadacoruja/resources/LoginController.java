package br.com.tokadacoruja.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokadacoruja.domain.User;
import br.com.tokadacoruja.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@GetMapping("/cadastrar-usuario")
	public ModelAndView register(User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/register");
		mv.addObject("user", user);
		mv.addObject("usuario", new User());
		return mv;
	}
	
	@PostMapping("/cadastrar-usuario")
	public ModelAndView register(@Valid User user, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		User usr = userService.findByEmail(user.getEmail());
		if(usr != null) {
			result.rejectValue("email", "", "Usuário já cadastrado!");
		}
		if(result.hasErrors()) {
			mv.setViewName("login/register");
			mv.addObject("usuario", user);
		}else {
			userService.save(user);
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	
	
}
