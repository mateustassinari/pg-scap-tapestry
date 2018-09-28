package br.ufes.scap_tapestry.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Professor extends Pessoa {

	private static final long serialVersionUID = 1L;	

}