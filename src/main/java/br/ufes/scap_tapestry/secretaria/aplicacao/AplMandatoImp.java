package br.ufes.scap_tapestry.secretaria.aplicacao;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;

import br.ufes.scap_tapestry.entities.Mandato;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.secretaria.persistencia.MandatoDAO;
import br.ufes.scap_tapestry.secretaria.persistencia.PessoaDAO;

public class AplMandatoImp implements AplMandato{

	@Inject
	private PessoaDAO pessoaDAO;
	
	@Inject 
	private MandatoDAO mandatoDAO;
	
	@Override
	public void salvar(Mandato novoMandato, String matricula) {
		Pessoa chefeDepatamento;
		chefeDepatamento = pessoaDAO.buscaMatricula(matricula);
		novoMandato.setPessoa(chefeDepatamento);
		mandatoDAO.salvar(novoMandato);
	}

	@Override
	public boolean checaMandato(String id_pessoa) {
		return mandatoDAO.checaMandato(id_pessoa);
	}

	@Override
	public List<Mandato> busca() {
		return mandatoDAO.listaMandatos();
	}
	
}