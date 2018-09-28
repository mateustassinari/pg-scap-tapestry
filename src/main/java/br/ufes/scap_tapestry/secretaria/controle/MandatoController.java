package br.ufes.scap_tapestry.secretaria.controle;

import java.text.ParseException;
import java.util.Date;

public interface MandatoController {

	boolean salva(String matricula, Date data_iniMandato, Date data_fimMandato) throws ParseException;

	String getNotificacao();

	void setNotificacao(String notificacao);

}