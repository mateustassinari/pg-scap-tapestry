package br.ufes.scap_tapestry.nucleo.aplicacao;

import br.ufes.scap_tapestry.entities.Pessoa;

public class UsuarioImp implements Usuario {

	private Pessoa logado;
	
	@Override
	public void login(Pessoa usuario) {
	    this.logado = usuario;
	}

	@Override
	public boolean isLogado() {
	    return logado != null;
	}
	
	@Override
	public String getMatricula(){
		return logado.getMatricula();
	}
	
	@Override
	public Pessoa getLogado(){
		return logado;
	}
	
	@Override
	public void logout(){
		this.logado = null;
	}
	
}