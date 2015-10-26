package com.hp.idescat.cerda.metadata.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DEFIDIOMA database table.
 * 
 */
@Entity
@NamedQuery(name="Defidioma.findAll", query="SELECT d FROM Defidioma d")
public class Defidioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idestadistica;

	//bi-directional one-to-one association to Estadistica
	@OneToOne
	@JoinColumn(name="IDESTADISTICA")
	private Estadistica estadistica;

	//bi-directional many-to-one association to Idioma
	@ManyToOne
	@JoinColumn(name="IDIDIOMA")
	private Idioma idioma;

	public Defidioma() {
	}

	public long getIdestadistica() {
		return this.idestadistica;
	}

	public void setIdestadistica(long idestadistica) {
		this.idestadistica = idestadistica;
	}

	public Estadistica getEstadistica() {
		return this.estadistica;
	}

	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}

	public Idioma getIdioma() {
		return this.idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

}