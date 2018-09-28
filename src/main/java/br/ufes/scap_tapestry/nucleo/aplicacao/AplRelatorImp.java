package br.ufes.scap_tapestry.nucleo.aplicacao;

import org.apache.tapestry5.ioc.annotations.Inject;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Relator;
import br.ufes.scap_tapestry.entities.SituacaoSolic;
import br.ufes.scap_tapestry.nucleo.persistencia.AfastamentoDAO;
import br.ufes.scap_tapestry.nucleo.persistencia.RelatorDAO;

public class AplRelatorImp implements AplRelator{											
	
	@Inject
	private AfastamentoDAO afastamentoDAO;
	
	@Inject
	private RelatorDAO relatorDAO;
		
	@Override
	public void salvar(Relator relator, Afastamento afastamento) {
		
		relator.setAfastamento(afastamento);
		
		SituacaoSolic situacao = SituacaoSolic.LIBERADO;
		afastamento.setSituacaoSolicitacao(situacao);
		
		afastamentoDAO.merge(afastamento);
		
		
		relatorDAO.salvar(relator);
	}

	@Override
	public Relator buscaPorAfastamento(String id_afastamento) {
		return relatorDAO.buscaPorAfastamento(id_afastamento);
	}

}