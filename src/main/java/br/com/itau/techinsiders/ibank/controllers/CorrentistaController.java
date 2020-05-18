package br.com.itau.techinsiders.ibank.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.techinsiders.ibank.models.Correntista;
import br.com.itau.techinsiders.ibank.models.Pessoa;
import br.com.itau.techinsiders.ibank.models.dto.NewAccount;
import br.com.itau.techinsiders.ibank.repository.CorrentistaRepository;
import br.com.itau.techinsiders.ibank.repository.PessoaRepository;

@RestController
public class CorrentistaController {
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@PostMapping("/correntista")
	public Correntista addCorrentista(@RequestBody NewAccount novaConta) {
		
		System.out.println(novaConta.getIdPessoa());
		Optional<Pessoa> pessoa = pessoaRepository.findById(novaConta.getIdPessoa());
		System.out.println(pessoa.get().getId());
		if(pessoa.isPresent()) {
			
			Correntista correntista = new Correntista();
			correntista.setPessoa(pessoa.get());
			correntista.setSaldo(novaConta.getSaldoInicial());
			
			correntista = correntistaRepository.save(correntista);
			
			return correntista;
			
			
		}
		
		return null;
		
	}

}
