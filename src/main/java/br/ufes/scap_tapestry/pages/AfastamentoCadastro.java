package br.ufes.scap_tapestry.pages;

import java.text.ParseException;
import java.util.Date;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.entities.Onus;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.entities.TipoAfastamento;
import br.ufes.scap_tapestry.nucleo.aplicacao.Usuario;
import br.ufes.scap_tapestry.nucleo.controle.AfastamentoController;
import br.ufes.scap_tapestry.nucleo.controle.VerificaPermissaoController;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;

public class AfastamentoCadastro {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private AfastamentoController afastControle;
		
	  @Inject
	  private VerificaPermissaoController verificaControle;
		
	  @Inject
	  private Usuario usuarioWeb;
	 	
	  @Inject
	  private AplPessoa aplPessoa;
	  
	  @InjectComponent
	  private Form cadastro;

	  @Property
	  private String nomeevento;

	  @Property
	  private String nomecidade;

	  @Property
	  private Date datainicio_afast;
	 
	  @Property
	  private Date datafim_afast;
	 
	  @Property
	  private Date datainicio_evento;
	 
	  @Property
	  private Date datafim_evento;
	  
	  @Property
	  @Validate("required")
	  private TipoAfastamento tipoAfastamento;
	  
	  @Property
	  @Validate("required")
	  private Onus tipoOnus;

	  @Property
	  private String motivo_afast;
	  
	  @Property
	  private String dateInFormatStr = "dd/MM/yyyy";
	 
	  Object onActivate() {
		  
		  Pessoa pessoa_aux = new Pessoa();
	      pessoa_aux = aplPessoa.buscaMatricula(usuarioWeb.getMatricula());
	      if(!verificaControle.verifica_prof(pessoa_aux)) {
	      
	    	alertManager.error(verificaControle.getNotificacao());
	        return AfastamentoBuscar.class;
	      
	      }
	      
	      return null;
	  
	  }
	  
	  @CommitAfter
	  Object onSuccessFromCadastro() throws ParseException {
		  
		  if(afastControle.salva(nomeevento,nomecidade,tipoAfastamento,tipoOnus,datainicio_afast,datafim_afast,datainicio_evento,datafim_evento,motivo_afast)) {
			  
			  logger.info("Successful!");
			  alertManager.success("Cadastro feito!");
			  return AfastamentoBuscar.class;
		  
		  } else {
			  
			  logger.warn("Error!");
			  alertManager.error(afastControle.getNotificacao());
			  return AfastamentoCadastro.class;
			
		  }
		  
	  }
	  	  	  
}
