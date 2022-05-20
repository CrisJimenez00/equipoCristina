package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jugador database table.
 * 
 */
@Entity
@Table(name="jugador")
@NamedQuery(name="Jugador.findAll", query="SELECT j FROM Jugador j")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codficha;

	private String ape1;

	private String ape2;

	private String dni;

	private String nombre;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="codequipo")
	private Equipo equipo;

	public Jugador() {
	}

	public int getCodficha() {
		return this.codficha;
	}

	public void setCodficha(int codficha) {
		this.codficha = codficha;
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
		builder.append("Jugador [codficha=");
		builder.append(codficha);
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