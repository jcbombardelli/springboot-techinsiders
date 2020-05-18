package br.com.itau.techinsiders.ibank.repository;

import br.com.itau.techinsiders.ibank.models.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
	public Pessoa findPessoaByTelefone(String telefone);


}
