package br.com.tokadacoruja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.repositories.ChildrenRepository;

@Controller
public class ChildrenController {

	@Autowired
	private ChildrenRepository childrenRepository; 
	
	@GetMapping("/criancas/cadastro")
	public String form() {
		return "childrens/form";
	}
	
	@PostMapping("/criancas")
	public String save(Children children) {
		childrenRepository.save(children);
		return "parents/sucesso"; 
	}
}
