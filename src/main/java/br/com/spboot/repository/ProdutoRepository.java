package br.com.spboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.spboot.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{}