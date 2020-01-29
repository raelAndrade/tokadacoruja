package br.com.tokadacoruja.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login/login");
        return modelAndView;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		User user = new User();
        mv.addObject("user", user);
		mv.setViewName("login/register");
		return mv;
	}
	
	@PostMapping("/cadastro")
	public ModelAndView createNewUser(@Valid User user, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		User userExists = userService.findUserByUserName(user.getName());
		if(userExists != null) {
			result.rejectValue("userName", "error.user", "Usuário já cadastrado!");
		}
		if(result.hasErrors()) {
			mv.setViewName("login/register");
		}else {
			userService.saveUser(user);
			mv.addObject("mensagem", "Usuário cadastrado com sucesso!");
			mv.addObject("user", new User());
			mv.setViewName("redirect:/login/register");
		}
		return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("mensagem", user.getName());
        modelAndView.setViewName("index");
        return modelAndView;
    }
	
	
}
