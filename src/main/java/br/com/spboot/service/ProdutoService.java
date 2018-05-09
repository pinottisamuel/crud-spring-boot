package br.com.spboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.spboot.models.Produto;
import br.com.spboot.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	
	public Produto save(Produto produto) {
		return repository.save(produto);		
	}

	public Iterable<Produto> findAll() {
		return repository.findAll();
	}
	
	public Optional<Produto> findOne(Long id) {
		return repository.findById(id);
	}
	
	
	public void delete(Long id) {
		repository.deleteById(id);
		
	}
}
