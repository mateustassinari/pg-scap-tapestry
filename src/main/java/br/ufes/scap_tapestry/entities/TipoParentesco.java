package br.ufes.scap_tapestry.entities;

public enum TipoParentesco {
	MATRIOMONIAL("MATRIOMONIAL"),   
    SANGUINEO("SANGUINEO");
	
	private String tipoParentesco;  
	
	TipoParentesco(String tipo_Parentesco){  
	       this.tipoParentesco = tipo_Parentesco;  
	}  
	  
	public String getTipoParentesco(){  
	       return tipoParentesco;  
	}
}