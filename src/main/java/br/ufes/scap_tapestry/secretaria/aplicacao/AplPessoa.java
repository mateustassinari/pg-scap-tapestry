package br.ufes.scap_tapestry.secretaria.aplicacao;

import java.util.List;

import br.ufes.scap_tapestry.entities.Pessoa;

public interface AplPessoa {
	
	void salvar(Pessoa novoUsuario);
	
	Pessoa buscaMatricula(String matricula);
	
	List<Pessoa> buscaNome(String nome,String sobreNome);

	List<Pessoa> listaPessoas();
	
}