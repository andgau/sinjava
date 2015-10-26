package es.sinjava.jndiexample.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ESTADISTICA database table.
 * 
 */
@Entity
@NamedQuery(name="Estadistica.findAll", query="SELECT e FROM Estadistica e")
public class Estadistica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idestadistica;

	private String descripcion;

	private String nombre;

	//bi-directional one-to-one association to Defidioma
	@OneToOne(mappedBy="estadistica")
	private Defidioma defidioma;

	//bi-directional many-to-many association to Idioma
	@ManyToMany
	@JoinTable(
		name="ESTADISTICA_IDIOMA"
		, joinColumns={
			@JoinColumn(name="IDESTADISTICA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDIDIOMA")
			}
		)
	private List<Idioma> idiomas;

	public Estadistica() {
	}

	public long getIdestadistica() {
		return this.idestadistica;
	}

	public void setIdestadistica(long idestadistica) {
		this.idestadistica = idestadistica;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Defidioma getDefidioma() {
		return this.defidioma;
	}

	public void setDefidioma(Defidioma defidioma) {
		this.defidioma = defidioma;
	}

	public List<Idioma> getIdiomas() {
		return this.idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

}