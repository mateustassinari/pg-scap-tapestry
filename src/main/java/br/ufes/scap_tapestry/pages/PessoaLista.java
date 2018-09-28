package br.ufes.scap_tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;
import br.ufes.scap_tapestry.secretaria.controle.ParentescoController;
import br.ufes.scap_tapestry.secretaria.controle.PessoaController;

public class PessoaLista {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private PessoaController pessoaControle;

	  @Inject
	  private ParentescoController parentescoControle;
		
	  @Inject
	  private AplPessoa aplPessoa;
		 
	  @Property
	  private Pessoa pessoa;
		
		
	  public List<Pessoa> getPessoas() {
		
		  List<Pessoa> tabela = new ArrayList<Pessoa>();	
		  tabela = pessoaControle.getListaPessoa();
		  return tabela;
	  }
		
	  Object onActionFromCadastrar(String pessoaMatricula) {
		      
		  pessoa = aplPessoa.buscaMatricula(pessoaMatricula);
		  if(pessoa.getTipoPessoa().equals("1")) {
			  parentescoControle.setMatricula1(pessoaMatricula);
			  return ParentescoCadastro.class;
		  } else {
			  	alertManager.error("É possivel cadastrar parentesco somente entre professores");
			  	return PessoaLista.class;
				}
	  }  
}
