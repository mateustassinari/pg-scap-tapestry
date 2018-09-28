package br.ufes.scap_tapestry.secretaria.controle;

import java.util.List;

import br.ufes.scap_tapestry.entities.Pessoa;

public interface PessoaController {

	void salvar(Pessoa pessoa);

	void busca(String nome, String sobreNome);

	List<Pessoa> getListaPessoa();

	void setListaPessoa(List<Pessoa> listaPessoa);

}