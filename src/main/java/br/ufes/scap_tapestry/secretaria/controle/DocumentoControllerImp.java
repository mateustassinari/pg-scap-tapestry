package br.ufes.scap_tapestry.secretaria.controle;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Documento;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplDocumento;

public class DocumentoControllerImp implements DocumentoController {

	private String idAfastamento;
	
	@Inject
	private AplDocumento aplDocumento;	
	
	
	public void salva(Afastamento afastamento,UploadedFile file,String name) throws IOException, ParseException{
		
		Documento documento = new Documento();
		Calendar cal = Calendar.getInstance();
		
		documento.setData_juntada(cal);
		documento.setAfastamento(afastamento);
		documento.setTituloDocumento(name);
		documento.setNomeArquivo(file.getFileName());
		if (!(file.getSize() == 0)) {
            long bytes = file.getSize();
            documento.setContent(bytes);
        }
		aplDocumento.salvar(documento);		
	}

	@Override
	public String getIdAfastamento() {
		return idAfastamento;
	}

	@Override
	public void setIdAfastamento(String idAfastamento) {
		this.idAfastamento = idAfastamento;
	}
	
}