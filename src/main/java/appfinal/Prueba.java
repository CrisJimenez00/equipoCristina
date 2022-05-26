package appfinal;

import java.security.DrbgParameters.NextBytes;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import controladores.ControladorEntrenador;
import controladores.ControladorEquipo;
import controladores.ControladorJugador;
import entidades.Entrenador;
import entidades.Equipo;
import entidades.Jugador;

public class Prueba {

	// Como se usa en la mayoría de métodos lo uso como atributo de clase para no
	// repetir código.
	private static Scanner teclado;

	// Controladores necesarios
	private static ControladorEntrenador contEntre = new ControladorEntrenador();
	private static ControladorEquipo contEqui = new ControladorEquipo();
	private static ControladorJugador contJuga = new ControladorJugador();

	// Método el cual organiza todo el menú
	public static void menu() {

		boolean salida = false;
		teclado = new Scanner(System.in);

		try {

			do {
				System.out.println("Elija con cual tabla quiere trabajar(inserte el número):\n" + "1.Entrenador\n"
						+ "2.Equipo\n" + "3.Jugador\n" + "4.Salir");
				int opcionTeclado = teclado.nextInt();

				switch (opcionTeclado) {

				// Caso de elegir entrenador
				case 1:

					menuInternoEntrenador();
					break;

				// Caso de elegir equipo
				case 2:

					menuInternoEquipo();
					break;

				// Caso de elegir jugador
				case 3:

					menuInternoJugador();
					break;

				// En caso de salir
				case 4:

					System.out.println("Hasta la próxima");
					salida = true;
					break;
				default:

					System.out.println("Introduzca 1, 2 o 3");
					break;
				}
			} while (!salida);

		} catch (NumberFormatException nfe) {
			System.out.println("Introduzca un número, no una letra, gracias");
		}

	}

	// -----------ENTRENADOR-------------

	// Método el cual hace las funciones dentro de la tabla entrenador
	public static void menuInternoEntrenador() {

		teclado = new Scanner(System.in);

		List<Entrenador> listaEntrenador = contEntre.findAll();

		try {

			System.out.println("Elija que desea hacer(inserte el número):\n" + "1.Mostrar datos\n" + "2.Crear\n"
					+ "3.Eliminar\n" + "4.Editar\n" + "5.Buscar por código\n" + "6.salir");

			int opcionTeclado = teclado.nextInt();
			switch (opcionTeclado) {

			// Caso de elegir mostrarDatos
			case 1:

				mostrarEntrenador(contEntre);
				break;

			// Caso de elegir crear
			case 2:

				crearEntrenador();
				break;

			// Caso de elegir eliminar
			case 3:

				eliminarEntrenador();
				break;

			// Caso de elegir editar
			case 4:

				modificarEntrenador();
				break;

			// Caso de elegir buscar por pk
			case 5:

				buscarPkEntrenador();
				break;

			// Caso salir
			case 6:

				System.out.println("Hasta la próxima");
				menu();
				break;
			default:

				System.out.println("Introduzca 1, 2, 3 o 4");
				break;
			}
		} catch (NumberFormatException nfe) {

			System.out.println("Introduzca un número, no una letra, gracias");

		} catch (InputMismatchException ime) {
			System.out.println("Ha insertado un elemento no correcto");
		}

	}

	// METODOS NECESARIOS PARA ENTRENADOR

	// Método el cual nos muestra por pantalla la tabla entrenador
	public static void mostrarEntrenador(ControladorEntrenador cen) {

		System.out.println("ENTRENADORES ---------------");
		for (Entrenador e : cen.findAll()) {

			System.out.println(e);

		}

	}

	// Método el cual crea los entrenadores
	public static void crearEntrenador() {

		Entrenador e1 = new Entrenador();
		System.out.println("Introduzca un dni");
		String dni = teclado.next();
		e1.setDni(dni);

		System.out.println("Introduzca un nombre");
		String nombre = teclado.next();
		e1.setNombre(nombre);

		System.out.println("Introduzca un primer apellido");
		String ape1 = teclado.next();
		e1.setApe1(ape1);

		System.out.println("Introduzca un segundo apellido");
		String ape2 = teclado.next();
		e1.setApe2(ape2);

		contEntre.crearPersonas(e1);

	}

	// Método el cual modifica por separado cada atributo del elemento
	public static void modificarEntrenador() {

		mostrarEntrenador(contEntre);

		try {

			System.out.println("¿A qué entrenador desea modificar?");
			int codigo = teclado.nextInt();

			Entrenador e2 = contEntre.findByPK(codigo);

			System.out.println("¿Qué desea cambiar?\n" + "1.DNI\n" + "2.Nombre\n" + "3.1er Apellido\n"
					+ "4.2do Apellido\n" + "5.Todo\n" + "6.Salir");
			int opcion = teclado.nextInt();

			switch (opcion) {

			// Cambia DNI
			case 1:

				System.out.println("¿Qué DNI quiere ponerle?");
				String dniModificado = teclado.next();
				e2.setDni(dniModificado);

				contEntre.modificarPersonas(e2);

				break;

			// Cambia Nombre
			case 2:

				System.out.println("¿Qué nombre quiere ponerle?");
				String nombreModificado = teclado.next();
				e2.setNombre(nombreModificado);

				contEntre.modificarPersonas(e2);
				break;

			// Cambia 1er Apellido
			case 3:

				System.out.println("¿Qué primer apellido quiere ponerle?");
				String ape1Modificado = teclado.next();
				e2.setNombre(ape1Modificado);
				contEntre.modificarPersonas(e2);
				break;

			// Cambia 2do Apellido
			case 4:

				System.out.println("¿Qué segundo apellido quiere ponerle?");
				String ape2Modificado = teclado.next();
				e2.setNombre(ape2Modificado);
				contEntre.modificarPersonas(e2);
				break;

			// Cambia Todo
			case 5:

				Entrenador e7 = new Entrenador();

				System.out.println("Introduzca un dni");
				String dniNuevo = teclado.next();
				e7.setDni(dniNuevo);

				System.out.println("Introduzca un nombre");
				String nombreNuevo = teclado.next();
				e7.setNombre(nombreNuevo);

				System.out.println("Introduzca un primer apellido");
				String ape1Nuevo = teclado.next();
				e7.setApe1(ape1Nuevo);

				System.out.println("Introduzca un segundo apellido");
				String ape2Nuevo = teclado.next();
				e7.setApe2(ape2Nuevo);

				contEntre.modificarPersonas(e7);
				break;

			case 6:

				System.out.println("Hasta la póxima");
				menu();
				break;

			default:

				System.out.println("Elija una opción correcta");

			}

		} catch (NumberFormatException nme) {
			System.out.println("Introduzca un número correcto para el código");
		}

	}

	// Método el cual elimina a un entrenador de la base de datos
	public static void eliminarEntrenador() {

		try {

			mostrarEntrenador(contEntre);
			System.out.println("Introduzca el codigo de entrenador que desee que se elimine");
			int codEntrenador = teclado.nextInt();
			Entrenador e = contEntre.findByPK(codEntrenador);
			contEntre.borrarPersonas(e);

		} catch (NumberFormatException nme) {

			System.out.println("Introduzca un número correcto para el código");

		} catch (IllegalArgumentException iae) {

			System.out.println("No existe un entrenador con ese código de entrenador");

		} catch (Exception e) {

			System.out.println("No se puede eliminar a ese entrenador");

		}

	}

	// Método el cual usaremos para buscar por pk(codentrenador) a un entrenador
	public static void buscarPkEntrenador() {

		try {

			System.out.println("Introduzca el codigo de entrenador que desee buscar");
			int codEntrenador = teclado.nextInt();
			Entrenador e = contEntre.findByPK(codEntrenador);

			System.out.println("El entrenador era: " + e.getNombre() + " " + e.getApe1());

		} catch (NumberFormatException nme) {

			System.out.println("Introduzca un número correcto para el código");

		}

	}

	// -------------------------------
	// ------------EQUIPO------------
	// -------------------------------

	// Método el cual hace las funciones dentro de la tabla equipo
	public static void menuInternoEquipo() {

		teclado = new Scanner(System.in);

		List<Equipo> listaEquipo = contEqui.findAll();

		try {

			System.out.println("Elija que desea hacer(inserte el número):\n" + "1.Mostrar datos\n" + "2.Crear\n"
					+ "3.Eliminar\n" + "4.Editar\n" + "5.Buscar por código\n" + "6.Salir");

			int opcionTeclado = teclado.nextInt();
			switch (opcionTeclado) {

			// Caso de elegir mostrarDatos
			case 1:

				mostrarEquipo(contEqui);
				break;

			// Caso de elegir crear
			case 2:

				crearEquipo();
				break;

			// Caso de elegir eliminar
			case 3:

				eliminarEquipo();
				break;

			// Caso de elegir editar
			case 4:

				modificarEquipo();
				break;

			// Caso de elegir buscar por pk
			case 5:

				buscarEquipo();
				break;

			case 6:

				menu();
				break;

			default:

				System.out.println("Introduzca 1, 2, 3, 4, 5 o 6");
				break;

			}

		} catch (NumberFormatException nfe) {

			System.out.println("Introduzca un número, no una letra, gracias");

		}

	}

	// MÉTODOS NECESARIOS PARA EQUIPO

	// Método el cual nos permite mostrar la tabla equipos por consola
	public static void mostrarEquipo(ControladorEquipo ceq) {

		System.out.println("EQUIPOS ---------------");
		for (Equipo e : ceq.findAll()) {

			System.out.println(e);

		}

	}

	// Método necesario para crear un equipo
	public static void crearEquipo() {

		Equipo eq1 = new Equipo();

		System.out.println("Introduzca un nombre para el equipo");
		String nombre = teclado.next();
		eq1.setNombre(nombre);

		System.out.println("Introduzca una direccion");
		String direcsede = teclado.next();
		eq1.setDirecsede(direcsede);

		try {

			System.out.println("Introduzca los fondos monetarios que tendrá el equipo");
			double fondos = teclado.nextDouble();
			eq1.setFondos(fondos);

		} catch (NumberFormatException nme) {

			System.out.println("Introduzca un número correcto para los fondos");

		}

		try {

			System.out.println();
			mostrarEntrenador(contEntre);
			System.out.println("Introduzca el codentrenador del entrenador que desee");
			int pkEntrenador = teclado.nextInt();
			eq1.setEntrenador(contEntre.findByPK(pkEntrenador));

		} catch (NumberFormatException nme) {

			System.out.println("Introduzca un número correcto para elegir al entrenador");

		} catch (Exception e) {

			System.out.println("Hay errores al elegir el entrenador");

		}

		contEqui.crearEquipo(eq1);

	}

	// Método el cual nos permite modificar el equipo
	public static void modificarEquipo() {

		mostrarEquipo(contEqui);

		try {

			System.out.println("¿A qué equipo desea modificar?");
			int codigo = teclado.nextInt();

			Equipo e2 = contEqui.findByPK(codigo);

			System.out.println("¿Qué desea cambiar?\n" + "1.Dirección\n" + "2.Fondos\n" + "3.Nombre\n"
					+ "4.Cambiar Entrenador\n" + "5.Salir");
			int opcion = teclado.nextInt();

			switch (opcion) {

			// Cambia Dirección
			case 1:

				System.out.println("¿Qué dirección quiere ponerle?");
				String direccionModificado = teclado.next();
				e2.setDirecsede(direccionModificado);

				contEqui.modificarEquipo(e2);

				break;

			// Cambia Fondos
			case 2:

				System.out.println("¿Qué fondo tendrá el equipo?");
				double fondo = teclado.nextDouble();
				e2.setFondos(fondo);

				contEqui.modificarEquipo(e2);
				break;

			// Cambia Nombre
			case 3:

				System.out.println("¿Qué nombre quiere ponerle?");
				String nombreModificado = teclado.next();
				e2.setNombre(nombreModificado);
				contEqui.modificarEquipo(e2);
				break;

			case 4:

				mostrarEntrenador(contEntre);
				try {

					System.out.println("Introduzca el codentrenador del entrenador nuevo");
					int pkNuevoEntrenador = teclado.nextInt();
					e2.setEntrenador(contEntre.findByPK(pkNuevoEntrenador));
					contEqui.modificarEquipo(e2);

				} catch (NumberFormatException nfe) {

					System.out.println("Inserte un número para el código válido");

				}

				break;

			case 5:
				System.out.println("Hasta la próxima");
				menu();
				break;

			default:

				System.out.println("Elija una opción correcta");

			}

		} catch (NumberFormatException nme) {
			System.out.println("Introduzca un número correcto para el código");
		}
	}

	// Método el cual nos permite eliminar el equipo
	public static void eliminarEquipo() {

		try {

			mostrarEquipo(contEqui);
			System.out.println("Introduzca el codigo del equipo que desee que se elimine");
			int codEquipo = teclado.nextInt();

			contEqui.borrarEquipo(contEqui.findByPK(codEquipo));

		} catch (NumberFormatException nme) {

			System.out.println("Introduzca un número correcto para el código");

		} catch (IllegalArgumentException iae) {

			System.out.println("No existe un entrenador con ese código de entrenador");

		} catch (Exception e) {

			System.out.println("No se puede eliminar a ese entrenador");

		}
	}

	// Método el cual nos permite buscar un equipo introduciendo la pk
	public static void buscarEquipo() {

		try {

			System.out.println("Introduzca el código de equipo que desee buscar");
			int codEquipo = teclado.nextInt();
			Equipo e = contEqui.findByPK(codEquipo);

			System.out.println("El equipo era: " + e.getNombre());

		} catch (NumberFormatException nme) {

			System.out.println("Introduzca un número correcto para el código");

		}

	}

	// ----------------------------
	// ------------JUGADOR---------
	// ----------------------------

	// Método el cual hace las funciones dentro de la tabla jugador
	public static void menuInternoJugador() {

		teclado = new Scanner(System.in);

		List<Jugador> listaJugador = contJuga.findAll();

		try {

			System.out.println("Elija que desea hacer(inserte el número):\n" + "1.Mostrar datos\n" + "2.Crear\n"
					+ "3.Eliminar\n" + "4.Editar\n" + "5.Buscar por código\n" + "6.Salir");

			int opcionTeclado = teclado.nextInt();
			switch (opcionTeclado) {

			// Caso de elegir mostrarDatos
			case 1:

				mostrarJugador(contJuga);
				break;

			// Caso de elegir crear
			case 2:

				crearJugador();
				break;

			// Caso de elegir eliminar
			case 3:

				eliminarJugador();
				break;

			// Caso de elegir editar
			case 4:

				modificarJugador();

				break;

			// Caso de elegir buscar por pk
			case 5:

				buscarPkJugador();
				break;

			case 6:

				menu();
				break;

			default:

				System.out.println("Introduzca 1, 2, 3 o 4");
				break;
			}

		} catch (NumberFormatException nfe) {

			System.out.println("Introduzca un número, no una letra, gracias");

		}

	}

	// Métodos internos necesarios para Jugador

	// Método el cual nos muestra por consola la tabla de Jugador
	public static void mostrarJugador(ControladorJugador cj) {

		System.out.println("JUGADORES ---------------");
		for (Jugador j : cj.findAll()) {

			System.out.println(j);

		}

	}

	// Método el cual permite crear un Jugador
	public static void crearJugador() {

		Jugador j1 = new Jugador();

		System.out.println("Introduzca un dni");
		String dni = teclado.next();
		j1.setDni(dni);

		System.out.println("Introduzca un nombre");
		String nombre = teclado.next();
		j1.setNombre(nombre);

		System.out.println("Introduzca un primer apellido");
		String ape1 = teclado.next();
		j1.setApe1(ape1);

		System.out.println("Introduzca un segundo apellido");
		String ape2 = teclado.next();
		j1.setApe2(ape2);

		mostrarEquipo(contEqui);

		try {

			System.out.println("Introduzca el código del equipo al cual pertenecerá el nuevo jugador");
			int codEquipo = teclado.nextInt();
			j1.setEquipo(contEqui.findByPK(codEquipo));

		} catch (NumberFormatException nme) {
			System.out.println("Introduzca un número correcto para el código");
		}

		contJuga.crearJugador(j1);

	}

	// Método el cual sirve para modificar a un jugador
	public static void modificarJugador() {

		mostrarJugador(contJuga);

		try {

			System.out.println("¿A qué jugador desea modificar?");
			int codigo = teclado.nextInt();

			Jugador e2 = contJuga.findByPK(codigo);

			System.out.println("¿Qué desea cambiar?\n" + "1.DNI\n" + "2.Nombre\n" + "3.1er Apellido\n"
					+ "4.2do Apellido\n" + "5.Todo\n" + "6.Salir");
			int opcion = teclado.nextInt();

			switch (opcion) {

			// Cambia DNI
			case 1:

				System.out.println("¿Qué DNI quiere ponerle?");
				String dniModificado = teclado.next();
				e2.setDni(dniModificado);

				contJuga.modificarJugador(e2);

				break;

			// Cambia Nombre
			case 2:

				System.out.println("¿Qué nombre quiere ponerle?");
				String nombreModificado = teclado.next();
				e2.setNombre(nombreModificado);

				contJuga.modificarJugador(e2);
				break;

			// Cambia 1er Apellido
			case 3:

				System.out.println("¿Qué primer apellido quiere ponerle?");
				String ape1Modificado = teclado.next();
				e2.setNombre(ape1Modificado);
				contJuga.modificarJugador(e2);
				break;

			// Cambia 2do Apellido
			case 4:

				System.out.println("¿Qué segundo apellido quiere ponerle?");
				String ape2Modificado = teclado.next();
				e2.setNombre(ape2Modificado);
				contJuga.modificarJugador(e2);
				break;

			// Cambia Todo
			case 5:

				Jugador e7 = new Jugador();

				System.out.println("¿Qué DNI quiere ponerle?");
				String dniModificadoNuevo = teclado.next();
				e2.setDni(dniModificadoNuevo);

				System.out.println("¿Qué nombre quiere ponerle?");
				String nombreModificadoNuevo = teclado.next();
				e2.setNombre(nombreModificadoNuevo);

				System.out.println("¿Qué primer apellido quiere ponerle?");
				String ape1ModificadoNuevo = teclado.next();
				e2.setNombre(ape1ModificadoNuevo);

				System.out.println("¿Qué segundo apellido quiere ponerle?");
				String ape2ModificadoNuevo = teclado.next();
				e2.setNombre(ape2ModificadoNuevo);

				mostrarEquipo(contEqui);

				try {

					System.out.println("Introduzca el codequipo del equipo nuevo");
					int pkNuevoEquipo = teclado.nextInt();
					e2.setEquipo(contEqui.findByPK(pkNuevoEquipo));

				} catch (NumberFormatException nfe) {

					System.out.println("Inserte un número para el código válido");

				}

				contJuga.modificarJugador(e2);
				break;

			case 6:

				menu();
				break;

			default:

				System.out.println("Elija una opción correcta");

			}

		} catch (NumberFormatException nme) {

			System.out.println("Introduzca un número correcto para el código");

		}
	}

	// Método el cual sirve para eliminar un jugador introduciendo su pk(codjugador)
	public static void eliminarJugador() {

		try {

			mostrarJugador(contJuga);
			System.out.println("Introduzca el codigo del jugador que desee que se elimine");
			int codJugador = teclado.nextInt();
			contJuga.borrarJugador(contJuga.findByPK(codJugador));

		} catch (NumberFormatException nme) {

			System.out.println("Introduzca un número correcto para el código");

		} catch (IllegalArgumentException iae) {

			System.out.println("No existe un entrenador con ese código de entrenador");

		} catch (Exception e) {

			System.out.println("No se puede eliminar a ese entrenador");

		}
	}

	// Método el cual encuentra un jugador a partir de su pk(codjugador)
	public static void buscarPkJugador() {

		try {

			System.out.println("Introduzca el codigo del jugador que desee buscar");
			int codJugador = teclado.nextInt();
			Jugador e = contJuga.findByPK(codJugador);

			System.out.println("El jugador era: " + e.getNombre() + " " + e.getApe1());

		} catch (NumberFormatException nme) {

			System.out.println("Introduzca un número correcto para el código");

		}
	}

	// ---------------------
	// --------MAIN---------
	// ---------------------
	public static void main(String[] args) {
		menu();
	}

}
