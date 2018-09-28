package br.ufes.scap_tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.nucleo.controle.AfastamentoController;
import br.ufes.scap_tapestry.nucleo.controle.DocumentoLista;
import br.ufes.scap_tapestry.nucleo.controle.ParecerController;
import br.ufes.scap_tapestry.nucleo.controle.RelatorController;
import br.ufes.scap_tapestry.secretaria.controle.DocumentoController;

public class AfastamentoMostrar {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private AfastamentoController afastControle;
		
	  @Inject
	  private RelatorController relatorControle;
		
	  @Inject
	  private ParecerController parecerControle;
		
	  @Inject
	  private DocumentoController documentoControle;
		
	  @Property
	  private List<String> dados;
	
	  @Property
	  private DocumentoLista documento;
	  
	  public List<DocumentoLista> getDocumentos() {
			
		  	List<DocumentoLista> tabela = new ArrayList<DocumentoLista>();	
			tabela = afastControle.getListaDocumento();
			return tabela;
		
	  }
	  
	  Object onActivate() {
			
		  dados = afastControle.buscar();  
		  if(dados == null) {							
			  
			 alertManager.error(afastControle.getNotificacao());
		     return AfastamentoBuscar.class;
		  
		  }
		  
		  relatorControle.setIdAfastamento(afastControle.getIdAfastamento());
	      parecerControle.setIdAfastamento(afastControle.getIdAfastamento());
	      documentoControle.setIdAfastamento(afastControle.getIdAfastamento());  
		  return null;
	  }
	  
}
