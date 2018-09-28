package br.ufes.scap_tapestry.pages;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.entities.Relator;
import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.entities.TipoParecer;
import br.ufes.scap_tapestry.nucleo.aplicacao.AplAfastamento;
import br.ufes.scap_tapestry.nucleo.aplicacao.AplRelator;
import br.ufes.scap_tapestry.nucleo.aplicacao.Usuario;
import br.ufes.scap_tapestry.nucleo.controle.ParecerController;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;

public class ParecerCadastro {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private ParecerController parecerControle;
	  
	  @Inject
	  private Usuario usuarioWeb;
	 	
	  @Inject
	  private AplPessoa aplPessoa;
	  
	  @Inject
	  private AplAfastamento aplAfastamento;

	  @Inject
	  private AplRelator aplRelator;
	
	  @InjectComponent
	  private Form cadastro;
	 
	  @Property
	  private String motivo;

	  @Property
	  @Validate("required")
	  private TipoParecer tipoParecer;

	  Object onActivate() {
			
		Pessoa pessoa_aux = new Pessoa();
		Afastamento afastamento = new Afastamento();
		Relator relator = new Relator();
		pessoa_aux = aplPessoa.buscaMatricula(usuarioWeb.getMatricula());
		afastamento = aplAfastamento.buscaId(parecerControle.getIdAfastamento());
		relator = aplRelator.buscaPorAfastamento(parecerControle.getIdAfastamento());
	    if(!parecerControle.verifica(pessoa_aux, afastamento, relator)) {
	    	alertManager.error(parecerControle.getNotificacao());
	    	return AfastamentoMostrar.class;	
		}
	    return null;
	  }
	  
	  @CommitAfter
	  Object onSuccessFromCadastro() {
			
		  parecerControle.salvar(motivo,tipoParecer);
		  logger.info("Successful!");
		  alertManager.success("Cadastro feito!");
		  return AfastamentoBuscar.class;
	  
	  }
	
}
