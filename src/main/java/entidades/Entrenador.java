package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the entrenador database table.
 * 
 */
@Entity
@NamedQuery(name = "Entrenador.findAll", query = "SELECT e FROM Entrenador e")
public class Entrenador implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codentrenador;

	private String ape1;

	private String ape2;

	private String dni;

	private String nombre;

	public Entrenador() {
	}

	public int getCodentrenador() {
		return this.codentrenador;
	}

	public void setCodentrenador(int codentrenador) {
		this.codentrenador = codentrenador;
	}

	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Entrenador [codentrenador=" + codentrenador + ", ape1=" + ape1 + ", ape2=" + ape2 + ", dni=" + dni
				+ ", nombre=" + nombre + "]";
	}

}