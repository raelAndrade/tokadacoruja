package br.com.tokadacoruja;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import br.com.tokadacoruja.domain.Evento;
import br.com.tokadacoruja.domain.Inscricao;
import br.com.tokadacoruja.repositories.EventoRepository;
import br.com.tokadacoruja.repositories.InscricaoRepository;

@SpringBootApplication
public class TokadacorujaApplication implements CommandLineRunner {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private InscricaoRepository inscricaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TokadacorujaApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	@Override
	public void run(String... args) throws Exception {

		Evento evento = new Evento(null, "Teste 1");
		System.out.println(evento);

		Inscricao inscricao = new Inscricao(null, "Israel", "israel@teste.com", evento);
		System.out.println(inscricao);
		
		inscricaoRepository.save(inscricao);
		eventoRepository.save(evento);
	}

}
