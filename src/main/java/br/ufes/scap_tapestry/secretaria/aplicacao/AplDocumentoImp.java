package br.ufes.scap_tapestry.secretaria.aplicacao;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;

import br.ufes.scap_tapestry.entities.Documento;
import br.ufes.scap_tapestry.secretaria.persistencia.DocumentoDAO;

public class AplDocumentoImp implements AplDocumento{

	@Inject
	private DocumentoDAO documentoDAO;
	
	@Override
	public void salvar(Documento documento) {
		documentoDAO.salvar(documento);	
	}

	@Override
	public Documento buscaId(String id_documento) {
		Documento documento = documentoDAO.buscaId(id_documento);
		return documento;
	}

	@Override
	public List<Documento> buscaPorAfastamento(String id_afastamento) {
		return documentoDAO.buscaPorAfastamento(id_afastamento);
	}

}