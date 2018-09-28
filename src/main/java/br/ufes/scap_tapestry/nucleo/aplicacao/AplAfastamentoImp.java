package br.ufes.scap_tapestry.nucleo.aplicacao;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Onus;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.entities.SituacaoSolic;
import br.ufes.scap_tapestry.entities.TipoAfastamento;
import br.ufes.scap_tapestry.nucleo.persistencia.AfastamentoDAO;

public class AplAfastamentoImp implements AplAfastamento{

	@Inject
	private AfastamentoDAO afastamentoDAO;
	
	@Override
	public void salvar(Afastamento novoAfastamento,Pessoa solicitante,TipoAfastamento tipo, Onus onusAfastamento, String motivo_afast) {
		novoAfastamento.setSolicitante(solicitante);
		novoAfastamento.setTipoAfastamento(tipo);
		novoAfastamento.setOnus(onusAfastamento);
		if(!(motivo_afast == null)) {
			novoAfastamento.setMotivo_afast(motivo_afast);
		}
		if(tipo.getTipoAfastamento().equals("NACIONAL")){
			SituacaoSolic situacao = SituacaoSolic.LIBERADO;
			novoAfastamento.setSituacaoSolicitacao(situacao);
		}else{
			SituacaoSolic situacao = SituacaoSolic.INICIADO;
			novoAfastamento.setSituacaoSolicitacao(situacao);
		}
		afastamentoDAO.salvar(novoAfastamento);
				
	}

	@Override
	public List<Afastamento> listaAfastamentos() {
		return afastamentoDAO.listaAfastamentos();
	}

	@Override
	public Afastamento buscaId(String id_afastamento) {
		return afastamentoDAO.buscaId(id_afastamento);
	}

	@Override
	public void mudarStatus(Afastamento afastamento, String novoStatus,Pessoa logado) {
		SituacaoSolic situacao = SituacaoSolic.valueOf(novoStatus);
		afastamento.setSituacaoSolicitacao(situacao);
		afastamentoDAO.merge(afastamento);
	}

}