package br.ufes.scap_tapestry.secretaria.aplicacao;

import org.apache.tapestry5.ioc.annotations.Inject;

import br.ufes.scap_tapestry.entities.Parentesco;
import br.ufes.scap_tapestry.entities.TipoParentesco;
import br.ufes.scap_tapestry.secretaria.persistencia.ParentescoDAO;
import br.ufes.scap_tapestry.secretaria.persistencia.PessoaDAO;

public class AplParentescoImp implements AplParentesco{

	@Inject
	private PessoaDAO pessoaDAO;
	
	@Inject
	private ParentescoDAO parentescoDAO;
	
	@Override
	public void salvar(String matricula1, String matricula2, TipoParentesco tipo) {
		
		Parentesco parentesco = new Parentesco();
		parentesco.setPessoa1(pessoaDAO.buscaMatricula(matricula1));
		parentesco.setPessoa2(pessoaDAO.buscaMatricula(matricula2));
		parentesco.setTipoParentesco(tipo);
		parentescoDAO.salvar(parentesco);
		
		Parentesco parentesco2 = new Parentesco();
		parentesco2.setPessoa1(pessoaDAO.buscaMatricula(matricula2));
		parentesco2.setPessoa2(pessoaDAO.buscaMatricula(matricula1));
		parentesco2.setTipoParentesco(tipo);
		parentescoDAO.salvar(parentesco2);
		
	}

	@Override
	public boolean checaParentesco(String matricula1, String matricula2) {
		return parentescoDAO.checaParentesco(matricula1, matricula2);
	}

}