package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipo database table.
 * 
 */
@Entity
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codequipo;

	private String direcsede;

	private double fondos;

	private String nombre;

	//uni-directional one-to-one association to Entrenador
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name="codentrenador")
	private Entrenador entrenador;

	//bi-directional many-to-one association to Jugador
	@OneToMany(mappedBy="equipo")
	private List<Jugador> jugadors;

	public Equipo() {
	}

	public int getCodequipo() {
		return this.codequipo;
	}

	public void setCodequipo(int codequipo) {
		this.codequipo = codequipo;
	}

	public String getDirecsede() {
		return this.direcsede;
	}

	public void setDirecsede(String direcsede) {
		this.direcsede = direcsede;
	}

	public double getFondos() {
		return this.fondos;
	}

	public void setFondos(double fondos) {
		this.fondos = fondos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Entrenador getEntrenador() {
		return this.entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(List<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	public Jugador addJugador(Jugador jugador) {
		getJugadors().add(jugador);
		jugador.setEquipo(this);

		return jugador;
	}

	public Jugador removeJugador(Jugador jugador) {
		getJugadors().remove(jugador);
		jugador.setEquipo(null);

		return jugador;
	}

	@Override
	public String toString() {
		return "Equipo [codequipo=" + codequipo + ", direcsede=" + direcsede + ", fondos=" + fondos + ", nombre="
				+ nombre + ", entrenador=" + entrenador.toString()  + "]";
	}
	//+ ", jugadors=" + jugadors

}