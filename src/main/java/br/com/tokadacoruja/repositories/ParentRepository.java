package br.com.tokadacoruja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tokadacoruja.domain.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

}
