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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tokadacoruja.domain.User;
import br.com.tokadacoruja.repositories.RoleRepository;
import br.com.tokadacoruja.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/login")
	public ModelAndView login() {
		final ModelAndView modelAndView = new ModelAndView("login/login");
        return modelAndView;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView register(final User user) {
		final ModelAndView mv = new ModelAndView("login/register");
		mv.addObject("roles", roleRepository.findAll());
        mv.addObject("user", user);
		return mv;
	}
	
	@PostMapping("/cadastro")
	public ModelAndView createNewUser(@Valid final User user, final BindingResult result, final RedirectAttributes attributes) {
		
		final ModelAndView mv = new ModelAndView();
		final User userExists = userService.findUserByUserName(user.getUserName());
		final User emailExists = userService.findUserByEmail(user.getEmail());
		
		if(userExists != null) {
			result.rejectValue("userName", "error.user", "Usuário já cadastrado!");
			mv.addObject("user", new User());
		}
		if(emailExists != null) {
			result.rejectValue("email", "error.user", "E-mail já cadastrado!");
		}
		if(result.hasErrors()) {
			return register(user);
		}
		userService.saveUser(user);
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
		return new ModelAndView("redirect:/login");
	}
	
	@GetMapping("/index")
	public ModelAndView home(){
        final ModelAndView modelAndView = new ModelAndView();
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("mensagem", user.getUserName());
        modelAndView.setViewName("index");
        return modelAndView;
    }
	
	
}
