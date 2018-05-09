package br.com.spboot.validation;

import java.math.BigDecimal;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.spboot.models.Produto;

public class ProdutoValidation implements Validator {

	@Override
	public boolean supports(Class<?> classe) {
		return Produto.class.isAssignableFrom(classe);
	}

	@Override
	public void validate(Object target, Errors errors) {	
		
		Produto produto = (Produto) target;
		
//		if(produto.getValor() != null && produto.getValor().compareTo(BigDecimal.ZERO) <= 0)
//			errors.rejectValue("valor", "field.required");
//		
//		
//		if(produto.getQuantidade() != null && produto.getQuantidade().compareTo(0) <= 0)
//			errors.rejectValue("quantidade", "field.required");
	}
}