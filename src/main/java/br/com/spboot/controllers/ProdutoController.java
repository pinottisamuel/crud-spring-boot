package br.com.spboot.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.spboot.models.Produto;
import br.com.spboot.service.ProdutoService;
import br.com.spboot.validation.ProdutoValidation;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/formulario")
	public ModelAndView form(Produto produto) {
		
		ModelAndView mv = new ModelAndView("/form-produto");
		mv.addObject("produto", produto);
		
		return mv;
	}
	
	@GetMapping("/listaProdutos")
	public ModelAndView lista() {
		
		ModelAndView mv = new ModelAndView("lista-produtos");
		mv.addObject("produtos", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		
		Optional<Produto> optional = service.findOne(id);
		
		Produto produto = optional.get();
		
		return form(produto);
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return lista();
	}
	
	
	@PostMapping("/gravar")
	public ModelAndView gravar(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors())
			return(form(produto));
		
		
		service.save(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto salvo com sucesso!");
		
		
		return new ModelAndView("redirect:/listaProdutos");
	}
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());		
	}
}
