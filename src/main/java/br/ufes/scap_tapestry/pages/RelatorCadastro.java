package br.ufes.scap_tapestry.pages;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.nucleo.aplicacao.AplAfastamento;
import br.ufes.scap_tapestry.nucleo.aplicacao.Usuario;
import br.ufes.scap_tapestry.nucleo.controle.RelatorController;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;

public class RelatorCadastro {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private RelatorController relatorControle;
	  
	  @Inject
	  private Usuario usuarioWeb;
	 	
	  @Inject
	  private AplPessoa aplPessoa;
	  
	  @Inject
	  private AplAfastamento aplAfastamento;
	  
	  @InjectComponent
	  private Form cadastro;
	 
	  @Property
	  private String matriculaRelator;
	 
	  Object onActivate() {
		
		  Pessoa pessoa_aux = new Pessoa();
		  Afastamento afastamento = new Afastamento();
		  pessoa_aux = aplPessoa.buscaMatricula(usuarioWeb.getMatricula());
		  afastamento = aplAfastamento.buscaId(relatorControle.getIdAfastamento());
		  if(!relatorControle.verifica(pessoa_aux, afastamento)) {
			  alertManager.error(relatorControle.getNotificacao());
			  return AfastamentoMostrar.class;	
		  }
		  return null;
	  }
		
	  @CommitAfter
	  Object onSuccessFromCadastro() {
			
		  if(relatorControle.salva(matriculaRelator)) {
			  
			  logger.info("Successful!");
			  alertManager.success("Cadastro feito!");
			  return AfastamentoBuscar.class;
		  
		  } else {
			  
			  logger.warn("Error!");
			  alertManager.error(relatorControle.getNotificacao());
			  return RelatorCadastro.class;
		  
		  }
		  
	  }
		  
		  
}
