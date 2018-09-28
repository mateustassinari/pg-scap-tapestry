package br.ufes.scap_tapestry.nucleo.aplicacao;

import br.ufes.scap_tapestry.entities.Pessoa;

public class UsuarioImp implements Usuario {

	private Pessoa logado;
	
	/* (non-Javadoc)
	 * @see br.ufes.scap_tapestry.nucleo.aplicacao.Usuario#login(br.ufes.scap_tapestry.entities.Pessoa)
	 */
	@Override
	public void login(Pessoa usuario) {
	    this.logado = usuario;
	}
	
	/* (non-Javadoc)
	 * @see br.ufes.scap_tapestry.nucleo.aplicacao.Usuario#isLogado()
	 */
	@Override
	public boolean isLogado() {
	    return logado != null;
	}
	
	/* (non-Javadoc)
	 * @see br.ufes.scap_tapestry.nucleo.aplicacao.Usuario#getMatricula()
	 */
	@Override
	public String getMatricula(){
		return logado.getMatricula();
	}
	
	/* (non-Javadoc)
	 * @see br.ufes.scap_tapestry.nucleo.aplicacao.Usuario#getLogado()
	 */
	@Override
	public Pessoa getLogado(){
		return logado;
	}
	
	/* (non-Javadoc)
	 * @see br.ufes.scap_tapestry.nucleo.aplicacao.Usuario#logout()
	 */
	@Override
	public void logout(){
		this.logado = null;
	}
	
}