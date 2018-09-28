package br.ufes.scap_tapestry.pages;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.nucleo.aplicacao.AplAfastamento;
import br.ufes.scap_tapestry.nucleo.aplicacao.Usuario;
import br.ufes.scap_tapestry.nucleo.controle.AfastamentoController;

public class MudarStatus {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private AfastamentoController afastControle; 
		
	  @Inject
	  private Usuario usuarioWeb;
	  
	  @Inject
	  private AplAfastamento aplAfastamento;
	  
	  @InjectComponent
	  private Form cadastro;
	  
	  @Property
	  private String tipoStatusProf;
	
	  @Property
	  private String tipoStatusSecre;
	  
	  public boolean isProfessor() {
		  return usuarioWeb.getLogado().getTipoPessoa().equals("1");
	  }
	  
	  Object onActivate() {
		  
		  Afastamento afastamento = new Afastamento();
	      afastamento = aplAfastamento.buscaId(afastControle.getIdAfastamento());
	      if(afastamento.getSituacaoSolicitacao().getStatusAfastamento().equals("ARQUIVADO") || afastamento.getSituacaoSolicitacao().getStatusAfastamento().equals("CANCELADO")) {
	        alertManager.error("Pedido já se encontra finalizado");
	        return AfastamentoMostrar.class;
	      }
	      return null;
	  }

	  
	  @CommitAfter
	  Object onSuccessFromCadastro() {
		
		  if(usuarioWeb.getLogado().getTipoPessoa().equals("1")) {
			
			  if(afastControle.mudarStatus(tipoStatusProf)) {
				
				 logger.info("Successful!");
				 return AfastamentoBuscar.class;
			
			  } else {
				  
				  logger.warn("Error!");
				  alertManager.error(afastControle.getNotificacao());
				  return MudarStatus.class;
				
			  	}
			  
		  } else { 
				  
			  if(afastControle.mudarStatus(tipoStatusSecre)) {
			    
				 logger.info("Successful!");
				 return AfastamentoBuscar.class;
			  	
			  } else {
				  
				  logger.warn("Error!");
				  alertManager.error(afastControle.getNotificacao());
				  return MudarStatus.class;
				
			  	}
				  
		  }
			  	  
	  }
	  
}
