package br.ufes.scap_tapestry.secretaria.controle;

import java.io.IOException;
import java.text.ParseException;

import org.apache.tapestry5.upload.services.UploadedFile;

import br.ufes.scap_tapestry.entities.Afastamento;

public interface DocumentoController {

	void salva(Afastamento afastamento,UploadedFile file,String name) throws IOException, ParseException;
	
	String getIdAfastamento();

	void setIdAfastamento(String idAfastamento);

}