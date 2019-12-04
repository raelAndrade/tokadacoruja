package br.com.tokadacoruja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.repositories.ChildrenRepository;

@Service
@Transactional
public class ChildrenService {

	@Autowired
	private ChildrenRepository childrenRepository;
	
	public List<Children> findAll() {
		return childrenRepository.findAll();
	}
	
//	public Optional<Children> findOne(Long id) {
//		return childrenRepository.findById(id);
//	}
	
	public Children save(Children children) {
		return childrenRepository.saveAndFlush(children);
	}
	
	public void delete(Long id) {
		childrenRepository.deleteById(id);
	}
}
