package es.sinjava.jndiexample.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the IDIOMA database table.
 * 
 */
@Entity
@NamedQuery(name="Idioma.findAll", query="SELECT i FROM Idioma i")
public class Idioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long ididioma;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Defidioma
	@OneToMany(mappedBy="idioma")
	private List<Defidioma> defidiomas;

	//bi-directional many-to-many association to Estadistica
	@ManyToMany(mappedBy="idiomas")
	private List<Estadistica> estadisticas;

	public Idioma() {
	}

	public long getIdidioma() {
		return this.ididioma;
	}

	public void setIdidioma(long ididioma) {
		this.ididioma = ididioma;
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

	public List<Defidioma> getDefidiomas() {
		return this.defidiomas;
	}

	public void setDefidiomas(List<Defidioma> defidiomas) {
		this.defidiomas = defidiomas;
	}

	public Defidioma addDefidioma(Defidioma defidioma) {
		getDefidiomas().add(defidioma);
		defidioma.setIdioma(this);

		return defidioma;
	}

	public Defidioma removeDefidioma(Defidioma defidioma) {
		getDefidiomas().remove(defidioma);
		defidioma.setIdioma(null);

		return defidioma;
	}

	public List<Estadistica> getEstadisticas() {
		return this.estadisticas;
	}

	public void setEstadisticas(List<Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}

}