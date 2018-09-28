package br.ufes.scap_tapestry.pages;

import java.text.ParseException;
import java.util.Date;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.nucleo.aplicacao.Usuario;
import br.ufes.scap_tapestry.nucleo.controle.VerificaPermissaoController;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;
import br.ufes.scap_tapestry.secretaria.controle.MandatoController;

public class MandatoCadastro {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private MandatoController mandatoControle;
	  
	  @Inject
	  private VerificaPermissaoController verificaControle;
		
	  @Inject
	  private Usuario usuarioWeb;
	 	
	  @Inject
	  private AplPessoa aplPessoa;
	  
	  @InjectComponent
	  private Form cadastro;
	
	  @Property
	  private String matriculaoutra;
	  
	  @Property
	  private Date datainicio;
	 
	  @Property
	  private Date datafim;
	  
	  @Property
	  private String dateInFormatStr = "dd/MM/yyyy";
	  
	  Object onActivate() {
		  
		  Pessoa pessoa_aux = new Pessoa();
	      pessoa_aux = aplPessoa.buscaMatricula(usuarioWeb.getMatricula());
	      if(!verificaControle.verifica_secre(pessoa_aux)) {
	        alertManager.error(verificaControle.getNotificacao());
	        return AfastamentoBuscar.class;
	      }
	      return null;
	  }

	  @CommitAfter
	  Object onSuccessFromCadastro() throws ParseException {
		
		if(mandatoControle.salva(matriculaoutra,datainicio,datafim)) {
		
			logger.info("Successful!");
			alertManager.success("Cadastro feito!");
			return AfastamentoBuscar.class;
		
		}  else {
			 
			logger.warn("Error!");
			alertManager.error(mandatoControle.getNotificacao());
			return MandatoCadastro.class;
			
			}
	  
	  }
	  	  
	   
}
