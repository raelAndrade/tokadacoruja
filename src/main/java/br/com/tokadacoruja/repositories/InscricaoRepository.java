package br.com.tokadacoruja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tokadacoruja.domain.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long>{

}
