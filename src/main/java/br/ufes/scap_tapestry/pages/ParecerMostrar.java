package br.ufes.scap_tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.nucleo.controle.ParecerController;
import br.ufes.scap_tapestry.nucleo.controle.ParecerLista;

public class ParecerMostrar {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private ParecerController parecerControle;

	  @Property
	  private ParecerLista parecer;
		
	  public List<ParecerLista> getPareceres() {
		
		 List<ParecerLista> tabela = new ArrayList<ParecerLista>();	
		 tabela = parecerControle.listar();
		 return tabela;
	  
	  }
	  
}

