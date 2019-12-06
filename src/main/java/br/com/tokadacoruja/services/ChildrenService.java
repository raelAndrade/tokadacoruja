package br.com.tokadacoruja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.repositories.ChildrenRepository;

@Service
public class ChildrenService {

	@Autowired
	private ChildrenRepository childrenRepository;
	
	@Transactional
	public void save(Children children) {
		childrenRepository.save(children);
	}
	
}
