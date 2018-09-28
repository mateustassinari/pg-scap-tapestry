package br.ufes.scap_tapestry.secretaria.controle;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;

import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;

public class PessoaControllerImp implements PessoaController {
	
	private List<Pessoa> listaPessoa;
	
	@Inject
	private AplPessoa aplPessoa;
	
	@Override
	public void salvar(Pessoa pessoa){
		aplPessoa.salvar(pessoa);
	}
	
	@Override
	public void busca(String nome,String sobreNome){
		this.listaPessoa = aplPessoa.buscaNome(nome, sobreNome);
	}

	@Override
	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	@Override
	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

}