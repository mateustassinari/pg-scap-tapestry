package br.ufes.scap_tapestry.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.*;

import br.ufes.scap_tapestry.nucleo.aplicacao.Usuario;
import br.ufes.scap_tapestry.pages.Login;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.SymbolConstants;

/**
 * Layout component for pages of application test-project.
 */
@Import(module="bootstrap/collapse")
public class Layout
{
  @Inject
  private ComponentResources resources;

  /**
   * The page title, for the <title> element and the <h1> element.
   */
  @Property
  @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
  private String title;

  @Property
  private String pageName;

  @Property
  @Inject
  @Symbol(SymbolConstants.APPLICATION_VERSION)
  private String appVersion;

  @Inject
  private Usuario usuarioWeb;
  
  public String getClassForPageName()
  {
    return resources.getPageName().equalsIgnoreCase(pageName)
        ? "active"
        : null;
  }

  public String[] getPageNames()
  {
    return new String[]{"AfastamentoBuscar", "PessoaBusca","PessoaCadastro","MandatoCadastro"};
  }

  Object onActionFromLogout(){
	  usuarioWeb.logout();
	  return Login.class;
  }

  
}
