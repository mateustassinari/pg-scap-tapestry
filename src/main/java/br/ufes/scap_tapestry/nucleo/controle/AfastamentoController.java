package br.ufes.scap_tapestry.nucleo.controle;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import br.ufes.scap_tapestry.entities.Onus;
import br.ufes.scap_tapestry.entities.TipoAfastamento;

public interface AfastamentoController {

	boolean salva(String nome_evento, String nome_cidade, TipoAfastamento tipo, Onus onusAfastamento,
			Date data_iniAfast, Date data_fimAfast, Date data_iniEvento, Date data_fimEvento,
			String motivo_afast) throws ParseException;

	List<AfastamentoLista> mostrar();

	List<String> buscar();

	boolean mudarStatus(String novoStatus);

	String getIdAfastamento();

	void setIdAfastamento(String idAfastamento);

	List<DocumentoLista> getListaDocumento();

	void setListaDocumento(List<DocumentoLista> listaDocumento);

	String getNotificacao();

	void setNotificacao(String notificacao);

}