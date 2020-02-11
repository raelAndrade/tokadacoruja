package br.com.tokadacoruja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tokadacoruja.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
