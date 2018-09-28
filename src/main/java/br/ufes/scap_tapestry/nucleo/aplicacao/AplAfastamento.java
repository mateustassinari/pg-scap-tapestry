package br.ufes.scap_tapestry.nucleo.aplicacao;

import java.util.List;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Onus;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.entities.TipoAfastamento;

public interface AplAfastamento {
	
	void salvar(Afastamento novoAfastamento,Pessoa solicitante,TipoAfastamento tipo,Onus onusAfastamento, String motivo_afast);
	
	List<Afastamento> listaAfastamentos();
	
	Afastamento buscaId(String id_afastamento);
	
	void mudarStatus(Afastamento afastamento,String novoStatus,Pessoa logado);
	
}