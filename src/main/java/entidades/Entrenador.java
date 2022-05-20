package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the entrenador database table.
 * 
 */
@Entity
@Table(name="entrenador")
@NamedQuery(name="Entrenador.findAll", query="SELECT e FROM Entrenador e")
public class Entrenador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codentrenador;

	private String ape1;

	private String ape2;

	private String dni;

	private String nombre;

	//bi-directional one-to-one association to Equipo
	@OneToOne
	@JoinColumn(name="codentrenador", referencedColumnName="codentrenador")
	private Equipo equipo;

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

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Entrenador [codentrenador=");
		builder.append(codentrenador);
		builder.append(", ape1=");
		builder.append(ape1);
		builder.append(", ape2=");
		builder.append(ape2);
		builder.append(", dni=");
		builder.append(dni);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", equipo=");
		builder.append(equipo);
		builder.append("]");
		return builder.toString();
	}
	

}