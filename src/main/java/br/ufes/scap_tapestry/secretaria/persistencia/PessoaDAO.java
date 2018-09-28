package br.ufes.scap_tapestry.secretaria.persistencia;

import java.util.List;

import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.nucleo.persistencia.BaseDAO;

public interface PessoaDAO extends BaseDAO<Pessoa> {
	
	Pessoa buscaMatricula(String Matricula);
	
	Pessoa buscaId(Long id_pessoa);
	
	List<Pessoa> buscaNome(String nome,String sobreNome);
	
	List<Pessoa> listaProfessores();
	
	List<Pessoa> listaPessoas();

}