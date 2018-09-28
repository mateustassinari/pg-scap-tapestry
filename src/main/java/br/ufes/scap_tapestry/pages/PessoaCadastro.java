package br.ufes.scap_tapestry.pages;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.jpa.annotations.CommitAfter;
import org.slf4j.Logger;

import br.ufes.scap_tapestry.nucleo.controle.VerificaPermissaoController;
import br.ufes.scap_tapestry.secretaria.controle.PessoaController;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.nucleo.aplicacao.Usuario;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;

public class PessoaCadastro {

	  @Inject
	  private Logger logger;

	  @Inject
	  private AlertManager alertManager;

	  @Inject
	  private PessoaController pessoaControle;
		
	  @Inject
	  private VerificaPermissaoController verificaControle;
		
	  @Inject
	  private Usuario usuarioWeb;
	 	
	  @Inject
	  private AplPessoa aplPessoa;
	  
	  @InjectComponent
	  private Form cadastro;
	  
	  @Property
	  private String nome;

	  @Property
	  private String sobrenome;
	  
	  @Property
	  private String email;
	 
	  @Property
	  private String matricula;
	  
	  @Property
	  private String telefone;
	  
	  @Property
	  private String password;
	  
	  @Property
	  @Validate("required")
	  private String tipoPessoa;

	  Object onActivate() {
		  
		  Pessoa pessoa_aux = new Pessoa();
	      pessoa_aux = aplPessoa.buscaMatricula(usuarioWeb.getMatricula());
	      if(!verificaControle.verifica_secre(pessoa_aux)) {
	        alertManager.error(verificaControle.getNotificacao());
	        return AfastamentoBuscar.class;
	      }
	      return null;
	  }

	  
	  @CommitAfter
	  Object onSuccessFromCadastro() {
		
		  Pessoa pessoa = new Pessoa();
		  pessoa.setNome(nome);
		  pessoa.setSobreNome(sobrenome);
		  pessoa.setEmail(email);
		  pessoa.setMatricula(matricula);
		  pessoa.setTelefone(telefone);
		  pessoa.setPassword(password);
		  pessoa.setTipoPessoa(tipoPessoa);
		  pessoaControle.salvar(pessoa);
		  logger.info("Successful!");
		  alertManager.success("Cadastro feito!");
	
		  return AfastamentoBuscar.class;
	  }
	
}
