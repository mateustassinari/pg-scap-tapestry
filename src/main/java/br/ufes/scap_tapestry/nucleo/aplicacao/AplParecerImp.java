package br.ufes.scap_tapestry.nucleo.aplicacao;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Parecer;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.entities.SituacaoSolic;
import br.ufes.scap_tapestry.entities.TipoParecer;
import br.ufes.scap_tapestry.nucleo.persistencia.AfastamentoDAO;
import br.ufes.scap_tapestry.nucleo.persistencia.ParecerDAO;

public class AplParecerImp implements AplParecer{

	@Inject
	private ParecerDAO parecerDAO;
	
	@Inject
	private AfastamentoDAO afastamentoDAO;
	
	@Override
	public void salvar(Parecer parecer, Afastamento afastamento, Pessoa usuario, TipoParecer tipoParecer) {
		parecerDAO.salvar(parecer);
		if(afastamento.getTipoAfastamento().getTipoAfastamento().equals("INTERNACIONAL")){
			if(usuario.getTipoPessoa().equals("2")) {
				if(afastamento.getSituacaoSolicitacao().getStatusAfastamento().equals("APROVADO_DI")){
					if(tipoParecer.get().equals("FAVORAVEL")) {
						SituacaoSolic situacao = SituacaoSolic.APROVADO_CT;
						afastamento.setSituacaoSolicitacao(situacao);
					}else{
						SituacaoSolic situacao = SituacaoSolic.REPROVADO;
						afastamento.setSituacaoSolicitacao(situacao);
						}
				} else {
						if(tipoParecer.get().equals("FAVORAVEL")) {
							SituacaoSolic situacao = SituacaoSolic.APROVADO_PRPPG;
							afastamento.setSituacaoSolicitacao(situacao);
						}else{
							SituacaoSolic situacao = SituacaoSolic.REPROVADO;
							afastamento.setSituacaoSolicitacao(situacao);
							}
						}	
			afastamentoDAO.merge(afastamento);
			} else if(tipoParecer.get().equals("DESFAVORAVEL")){
							SituacaoSolic situacao = SituacaoSolic.REPROVADO;
							afastamento.setSituacaoSolicitacao(situacao);
							} 
							else {
							SituacaoSolic situacao = SituacaoSolic.APROVADO_DI;
							afastamento.setSituacaoSolicitacao(situacao);
							}
					afastamentoDAO.merge(afastamento);
		}
		
	}		
		
	@Override
	public List<Parecer> buscaPorAfastamento(String id_afastamento) {
		return parecerDAO.buscaPorAfastamento(id_afastamento);
	}

}