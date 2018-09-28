package br.ufes.scap_tapestry.entities;

import java.util.Calendar;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Documento.class)
public class Documento_ {
	public static volatile SingularAttribute<Documento, Long> id_documento;
	public static volatile SingularAttribute<Documento, String> tituloDocumento;
	public static volatile SingularAttribute<Documento, String> nomeArquivo;
	public static volatile SingularAttribute<Documento, Afastamento> afastamento;
	public static volatile SingularAttribute<Documento, Calendar> data_juntada;
	public static volatile SingularAttribute<Documento, Long> content;
}

