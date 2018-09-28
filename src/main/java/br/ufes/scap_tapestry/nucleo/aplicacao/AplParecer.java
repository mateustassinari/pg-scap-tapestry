package br.ufes.scap_tapestry.nucleo.aplicacao;

import java.util.List;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Parecer;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.entities.TipoParecer;

public interface AplParecer {
	
	void salvar(Parecer parecer,Afastamento afastamento,Pessoa usuario,TipoParecer tipoParecer);
	
	List<Parecer> buscaPorAfastamento(String id_afastamento);
	
}