package br.ufes.scap_tapestry.nucleo.controle;

import java.util.List;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.entities.Relator;
import br.ufes.scap_tapestry.entities.TipoParecer;

public interface ParecerController {

	List<ParecerLista> listar();

	void salvar(String motivo, TipoParecer tipoParecer);

	boolean verifica(Pessoa pessoa_aux, Afastamento afastamento, Relator relator);

	String getIdAfastamento();

	void setIdAfastamento(String idAfastamento);

	String getNotificacao();

	void setNotificacao(String notificacao);

}