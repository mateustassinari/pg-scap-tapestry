package br.ufes.scap_tapestry.pages;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.entities.TipoParentesco;
import br.ufes.scap_tapestry.secretaria.controle.ParentescoController;

public class ParentescoCadastro {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private ParentescoController parentescoControle;
	  
	  @InjectComponent
	  private Form cadastro;
	 
	  @Property
	  private String matriculaParente;
	  
	  @Property
	  @Validate("required")
	  private TipoParentesco tipoParentesco;

	  @CommitAfter
	  Object onSuccessFromCadastro() {
		  
		  if(parentescoControle.salva(matriculaParente,tipoParentesco)) {
			  
			  logger.info("Successful!");
			  alertManager.success("Cadastro feito!");
			  return AfastamentoBuscar.class;
		  
		  } else {
			  
			  logger.warn("Error!");
			  alertManager.error(parentescoControle.getNotificacao());
			  return ParentescoCadastro.class;
		   
		  }
		  
	  }
	  
	  
}

