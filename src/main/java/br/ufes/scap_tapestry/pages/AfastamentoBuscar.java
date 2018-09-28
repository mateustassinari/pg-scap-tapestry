package br.ufes.scap_tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.nucleo.controle.AfastamentoController;
import br.ufes.scap_tapestry.nucleo.controle.AfastamentoLista;

public class AfastamentoBuscar {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private AfastamentoController afastControle;

	  @InjectComponent
	  private Form buscar;

	  @Property
	  private String id_afast;

	  @Property
	  private AfastamentoLista afastamento;
	
	  
	  public List<AfastamentoLista> getAfastamentos() {
			
		  	List<AfastamentoLista> tabela = new ArrayList<AfastamentoLista>();	
			tabela = afastControle.mostrar();
			return tabela;
	  
	  }
	  
	  Object onSuccessFromBuscar() {
		  
		afastControle.setIdAfastamento(id_afast);
		return AfastamentoMostrar.class;
	
	  }
	  
	  Object onActionFromVer(String afastamentoId) {
	
		  afastControle.setIdAfastamento(afastamentoId);
		  return AfastamentoMostrar.class;
	  
	  }
	  	  
}
