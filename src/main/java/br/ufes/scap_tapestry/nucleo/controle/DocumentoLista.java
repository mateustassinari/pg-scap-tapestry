package br.ufes.scap_tapestry.nucleo.controle;

import java.io.Serializable;

import org.apache.tapestry5.beaneditor.NonVisual;

public class DocumentoLista implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NonVisual
	private String id;
	
	private String titulo;
	
	@NonVisual
	private String arquivo;
	
	private String juntada;
	
	@NonVisual
	private long content;
	
	public DocumentoLista(){	
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getArquivo() {
		return arquivo;
	}
	
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	public String getJuntada() {
		return juntada;
	}
	
	public void setJuntada(String juntada) {
		this.juntada = juntada;
	}
	
	public long getContent() {
		return content;
	}
	
	public void setContent(long content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}