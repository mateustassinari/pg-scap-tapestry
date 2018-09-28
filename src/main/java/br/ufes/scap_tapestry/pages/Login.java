package br.ufes.scap_tapestry.pages;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.nucleo.aplicacao.Usuario;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;

public class Login {
  
	@Inject
	private Logger logger;

	@Inject
	private AlertManager alertManager;

	@Inject
	private Usuario usuarioWeb;
 	
	@Inject
	private AplPessoa aplPessoa;
  
	@InjectComponent
	private Form login;
  
	@InjectComponent("email")
	private TextField emailField;
  
	@InjectComponent("password")
	private PasswordField passwordField;

	@Property
	private String email;

	@Property
	private String password;

	void onValidateFromLogin() {
	  
		Pessoa pessoa = new Pessoa();
		pessoa = aplPessoa.buscaMatricula(email);
		if(pessoa!=null){
			if(pessoa.getPassword().equals(password)){
				usuarioWeb.login(pessoa);
			} else {
				login.recordError(passwordField, "Senha Incorreta");
			}
		} else {
		      login.recordError(emailField, "Matricula Inexistente");
			}
	}

	Object onSuccessFromLogin() {
		logger.info("Login successful!");
		alertManager.success("Welcome aboard!");
		return AfastamentoBuscar.class;
	}

	void onFailureFromLogin() {
		logger.warn("Login error!");
		alertManager.error("I'm sorry but I can't log you in!");
	}

}
