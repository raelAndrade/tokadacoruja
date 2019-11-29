package br.com.tokadacoruja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tokadacoruja.domain.Children;

public interface ChildrenRepository extends JpaRepository<Children, Long> {

}
