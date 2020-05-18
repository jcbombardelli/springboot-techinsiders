package br.com.itau.techinsiders.ibank.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.techinsiders.ibank.models.Pessoa;
import br.com.itau.techinsiders.ibank.repository.PessoaRepository;

@RestController
public class PessoaController {

	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@GetMapping("/pessoas")
	public Iterable<Pessoa> allPessoas() {
		return  pessoaRepository.findAll();
	}
	
	@PostMapping(path = "/pessoas", consumes = "application/json", produces = "application/json")
	public Pessoa addPessoa(@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		return pessoaSalva;
		
	}
	
	@GetMapping("/pessoas/{id}")
	public Optional<Pessoa> findPessoa(@PathVariable("id") long id) {
		return pessoaRepository.findById(id);
	}
	
	@DeleteMapping("/pessoas/{id}")
	public void removePessoa(@PathVariable("id") long id) {
		pessoaRepository.deleteById(id);
	}
	
	@GetMapping("/pessoas/telefone")
	public Optional<Pessoa> findPessoaByTelefone(@RequestParam("numero") String telefone) {
		Pessoa pessoa = pessoaRepository.findPessoaByTelefone("(13) 99172-8078");
		return Optional.ofNullable(pessoa);
		
	}
	

}
