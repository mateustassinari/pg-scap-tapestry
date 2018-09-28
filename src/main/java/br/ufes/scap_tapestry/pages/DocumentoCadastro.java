package br.ufes.scap_tapestry.pages;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.nucleo.aplicacao.AplAfastamento;
import br.ufes.scap_tapestry.secretaria.controle.DocumentoController;

public class DocumentoCadastro {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private DocumentoController documentoControle;

	  @Inject
	  private AplAfastamento aplAfastamento;
	  
	  @InjectComponent
	  private Form cadastro;
	 
	  @Property
	  private String titulo;
	  
	  @Property
	  private UploadedFile file;
	 
	  @CommitAfter
	  Object onSuccessFromCadastro() {
		  
		  Afastamento afastamento = new Afastamento();
		  afastamento = aplAfastamento.buscaId(documentoControle.getIdAfastamento());
		  if (file != null) {
				
			  File newFile = new File("C:\\dev\\" + file.getFileName());
			  if (newFile.exists()) {
				newFile.delete();
			  }
			  try {
				  newFile.createNewFile();
			  } catch (IOException e) {
				  e.printStackTrace();
					}
			  file.write(newFile);
			  try {
				  documentoControle.salva(afastamento,file,titulo);
			  } catch (IOException | ParseException e) {
				  e.printStackTrace();
					}
		  }
		  return AfastamentoBuscar.class;
	  }
	  
	
}
