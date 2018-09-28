package br.ufes.scap_tapestry.pages;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;

import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.nucleo.aplicacao.Usuario;
import br.ufes.scap_tapestry.nucleo.controle.VerificaPermissaoController;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;
import br.ufes.scap_tapestry.secretaria.controle.PessoaController;

public class PessoaBusca {

	  @Inject
	  private AlertManager alertManager;
	
	  @Inject
	  private PessoaController pessoaControle;
	
	  @Inject
	  private VerificaPermissaoController verificaControle;
	
	  @Inject
	  private AplPessoa aplPessoa;
	
	  @Inject
	  private Usuario usuarioWeb;
	
	  @InjectComponent
	  private Form buscar;
	  
	  @Property
	  private String nome;

	  @Property
	  private String sobrenome;
	
	  Object onActivate() {
		  
		  Pessoa pessoa_aux = new Pessoa();
	      pessoa_aux = aplPessoa.buscaMatricula(usuarioWeb.getMatricula());
	      if(!verificaControle.verifica_secre(pessoa_aux)) {
	        alertManager.error(verificaControle.getNotificacao());
	        return AfastamentoBuscar.class;
	      }
	      return null;
	  }

	  
	  Object onSuccessFromBuscar() {
		
		pessoaControle.busca(nome,sobrenome);	
	    return PessoaLista.class;
	  
	  }

}
