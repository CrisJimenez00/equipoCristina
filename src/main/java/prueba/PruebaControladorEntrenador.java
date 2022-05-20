package prueba;

import java.util.List;

import controladores.ControladorEntrenador;
import entidades.Entrenador;

public class PruebaControladorEntrenador {

	public static void main(String[] args) {
		ControladorEntrenador cv = new ControladorEntrenador();

		// Se obtienen todas las instancias
		List<Entrenador> listaVehiculos = cv.findAll();

		// Se imprime la lista
		System.out.println("Todas las entidades ------------ ");
		for (Entrenador v : listaVehiculos) {
			System.out.println(v);
		}

	}

}
