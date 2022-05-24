package prueba;

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

		teclado = new Scanner(System.in);

		try {

			System.out.println("Elija con cual tabla quiere trabajar(inserte el número):\n" + "1.Entrenador\n"
					+ "2.Equipo\n" + "3.Jugador\n" + "4.Salir");
			int opcionTeclado = teclado.nextInt();
			do {
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
				case 4:
					System.out.println("Hasta la próxima");
					break;
				default:

					System.out.println("Introduzca 1, 2 o 3");

				}
			} while (opcionTeclado != 3);

		} catch (NumberFormatException nfe) {
			System.out.println("Introduzca un número, no una letra, gracias");
		}

	}

	// Método el cual hace las funciones dentro de la tabla entrenador
	public static void menuInternoEntrenador() {

		teclado = new Scanner(System.in);

		List<Entrenador> listaEntrenador = contEntre.findAll();
		boolean fin = false;

		try {

			System.out.println("Elija que desea hacer(inserte el número):\n" + "1.Mostrar datos\n" + "2.Crear\n"
					+ "3.Eliminar\n" + "4.Editar\n" + "5.Buscar por código\n" + "6.salir");

			int opcionTeclado = teclado.nextInt();

			do {
				switch (opcionTeclado) {

				// Caso de elegir mostrarDatos
				case 1:
					mostrarEntrenador(contEntre);
					fin = true;
					break;

				// Caso de elegir crear
				case 2:
					Entrenador e1 = new Entrenador();
					try {

						System.out.println("Introduzca un código para el nuevo entrenador");
						int codentrenador = teclado.nextInt();
						e1.setCodentrenador(codentrenador);

					} catch (NumberFormatException nme) {
						System.out.println("Introduzca un número correcto para el código");
					}

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
					fin = true;
					break;

				// Caso de elegir eliminar
				case 3:
					try {

						mostrarEntrenador(contEntre);
						System.out.println("Introduzca el codigo de entrenador que desee que se elimine");
						int codEntrenador = teclado.nextInt();
						Entrenador e = contEntre.findByPK(codEntrenador);
						contEntre.borrarPersonas(e);

					} catch (NumberFormatException nme) {
						System.out.println("Introduzca un número correcto para el código");
					}

					fin = true;
					break;

				// Caso de elegir editar
				case 4:
					modificarEntrenador();
					fin = true;
					break;

				// Caso de elegir buscar por pk
				case 5:
					try {

						System.out.println("Introduzca el codigo de entrenador que desee buscar");
						int codEntrenador = teclado.nextInt();
						Entrenador e = contEntre.findByPK(codEntrenador);

						System.out.println("El entrenador era: " + e.getNombre() + " " + e.getApe1());
					} catch (NumberFormatException nme) {
						System.out.println("Introduzca un número correcto para el código");
					}
					fin = true;
					break;
				case 6:
					System.out.println("Hasta la próxima");
					fin = true;
					break;
				default:

					System.out.println("Introduzca 1, 2, 3 o 4");
					fin = true;

				}
			} while (!fin);

		} catch (NumberFormatException nfe) {

			System.out.println("Introduzca un número, no una letra, gracias");

		} catch (InputMismatchException ime) {
			System.out.println("Ha insertado un elemento no correcto");
		}
	}

	// Método el cual modifica por separado cada atributo del elemento
	private static void modificarEntrenador() {
		mostrarEntrenador(contEntre);

		try {

			System.out.println("¿A qué entrenador desea modificar?");
			int codigo = teclado.nextInt();

			Entrenador e2 = contEntre.findByPK(codigo);

			System.out.println("¿Qué desea cambiar?\n" + "1.Código de entrenador\n" + "2.DNI\n" + "3.Nombre\n"
					+ "4.1er Apellido\n" + "5.2do Apellido\n" + "6.Equipo\n" + "7.Todo");
			int opcion = teclado.nextInt();
			switch (opcion) {

			// Cambia el código
			case 1:

				try {

					System.out.println("¿Qué codigo desea ponerle?");
					int codigoNuevo = teclado.nextInt();
					e2.setCodentrenador(codigoNuevo);

				} catch (NumberFormatException nfe) {

					System.out.println("Inserte un número para el código válido");

				}

				contEntre.modificarPersonas(e2);
				break;

			// Cambia DNI
			case 2:

				System.out.println("¿Qué DNI quiere ponerle?");
				String dniModificado = teclado.next();
				e2.setDni(dniModificado);

				contEntre.modificarPersonas(e2);

				break;

			// Cambia Nombre
			case 3:

				System.out.println("¿Qué nombre quiere ponerle?");
				String nombreModificado = teclado.next();
				e2.setNombre(nombreModificado);

				contEntre.modificarPersonas(e2);
				break;

			// Cambia 1er Apellido
			case 4:

				System.out.println("¿Qué primer apellido quiere ponerle?");
				String ape1Modificado = teclado.next();
				e2.setNombre(ape1Modificado);

				break;

			// Cambia 2do Apellido
			case 5:

				System.out.println("¿Qué segundo apellido quiere ponerle?");
				String ape2Modificado = teclado.next();
				e2.setNombre(ape2Modificado);

				break;

			// Cambia Todo
			case 6:
				Entrenador e7 = new Entrenador();
				try {

					System.out.println("Introduzca un código para el nuevo entrenador");
					int codentrenador = teclado.nextInt();
					e7.setCodentrenador(codentrenador);

				} catch (NumberFormatException nme) {
					System.out.println("Introduzca un número correcto para el código");
				}

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
			case 8:
				System.out.println("Hasta la póxima");
				break;
			default:

				System.out.println("Elija una opción correcta");

			}

			mostrarEntrenador(contEntre);
		} catch (NumberFormatException nme) {
			System.out.println("Introduzca un número correcto para el código");
		}

	}

	public static void menuInternoEquipo() {

		teclado = new Scanner(System.in);

		List<Equipo> listaEquipo = contEqui.findAll();

		try {

			System.out.println("Elija que desea hacer(inserte el número):\n" + "1.Mostrar datos\n" + "2.Crear\n"
					+ "3.Eliminar\n" + "4.Editar\n" + "5.Buscar por código");

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
			default:

				System.out.println("Introduzca 1, 2, 3 o 4");

			}

		} catch (NumberFormatException nfe) {

			System.out.println("Introduzca un número, no una letra, gracias");

		}

	}

	//Métodos necesarios para trabajar con los datos de equipo(mirar si la codificación interna es correcta)
	private static void crearEquipo() {

		Equipo eq1 = new Equipo();
		try {

			System.out.println("Introduzca un código para el nuevo equipo");
			int codequipo = teclado.nextInt();
			eq1.setCodequipo(codequipo);

		} catch (NumberFormatException nme) {
			System.out.println("Introduzca un número correcto para el código");
		}

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

		contEqui.crearEquipo(eq1);

	}

	private static void eliminarEquipo() {

		try {

			mostrarEntrenador(contEntre);
			System.out.println("Introduzca el codigo del equipo que desee que se elimine");
			int codEquipo = teclado.nextInt();
			contEqui.borrarEquipo(contEqui.findByPK(codEquipo));

		} catch (NumberFormatException nme) {
			System.out.println("Introduzca un número correcto para el código");
		}

	}

	private static void buscarEquipo() {

		try {

			System.out.println("Introduzca el código de equipo que desee buscar");
			int codEquipo = teclado.nextInt();
			Equipo e = contEqui.findByPK(codEquipo);

			System.out.println("El equipo era: " + e.getNombre());
		} catch (NumberFormatException nme) {
			System.out.println("Introduzca un número correcto para el código");
		}

	}

	private static void modificarEquipo() {
		mostrarEquipo(contEqui);

		try {

			System.out.println("¿A qué equipo desea modificar?");
			int codigo = teclado.nextInt();

			Equipo e2 = contEqui.findByPK(codigo);

			System.out.println("¿Qué desea cambiar?\n" + "1.Código de equipo\n" + "2.Dirección\n" + "3.Fondos\n"
					+ "4.Nombre\n" + "5.Salir");
			int opcion = teclado.nextInt();
			switch (opcion) {

			// Cambia el código
			case 1:

				try {

					System.out.println("¿Qué codigo desea ponerle?");
					int codigoNuevo = teclado.nextInt();
					e2.setCodequipo(codigoNuevo);

				} catch (NumberFormatException nfe) {

					System.out.println("Inserte un número para el código válido");

				}

				contEqui.modificarEquipo(e2);
				break;

			// Cambia Dirección
			case 2:

				System.out.println("¿Qué dirección quiere ponerle?");
				String direccionModificado = teclado.next();
				e2.setDirecsede(direccionModificado);

				contEqui.modificarEquipo(e2);

				break;

			// Cambia Fondos
			case 3:

				System.out.println("¿Qué fondo tendrá el equipo?");
				double fondo = teclado.nextDouble();
				e2.setFondos(fondo);

				contEqui.modificarEquipo(e2);
				break;

			// Cambia Nombre
			case 4:

				System.out.println("¿Qué nombre quiere ponerle?");
				String nombreModificado = teclado.next();
				e2.setNombre(nombreModificado);

				break;

			case 5:

				System.out.println("Hasta la próxima");

				break;

			default:

				System.out.println("Elija una opción correcta");

			}

			mostrarEntrenador(contEntre);
		} catch (NumberFormatException nme) {
			System.out.println("Introduzca un número correcto para el código");
		}

	}

	public static void menuInternoJugador() {
		teclado = new Scanner(System.in);

		List<Jugador> listaJugador = contJuga.findAll();

		try {

			System.out.println("Elija que desea hacer(inserte el número):\n" + "1.Mostrar datos\n" + "2.Crear\n"
					+ "3.Eliminar\n" + "4.Editar\n" + "5.Buscar por código");

			int opcionTeclado = teclado.nextInt();

			switch (opcionTeclado) {

			// Caso de elegir mostrarDatos
			case 1:
				System.out.println("Todos los Jugadores------------ ");
				for (Jugador v : listaJugador) {
					System.out.println(v);
				}
				break;

			// Caso de elegir crear
			case 2:
				Entrenador e1 = new Entrenador();
				try {

					System.out.println("Introduzca un código para el nuevo entrenador");
					int codentrenador = teclado.nextInt();
					e1.setCodentrenador(codentrenador);

				} catch (NumberFormatException nme) {
					System.out.println("Introduzca un número correcto para el código");
				}

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
				break;

			// Caso de elegir eliminar
			case 3:
				try {

					mostrarEntrenador(contEntre);
					System.out.println("Introduzca el codigo de entrenador que desee que se elimine");
					int codEntrenador = teclado.nextInt();
					contEntre.borrarPersonas(contEntre.findByPK(codEntrenador));

				} catch (NumberFormatException nme) {
					System.out.println("Introduzca un número correcto para el código");
				}

				break;

			// Caso de elegir editar
			case 4:

				modificarJugador();

				break;

			// Caso de elegir buscar por pk
			case 5:
				try {

					System.out.println("Introduzca el codigo de entrenador que desee buscar");
					int codEntrenador = teclado.nextInt();
					Entrenador e = contEntre.findByPK(codEntrenador);

					System.out.println("El entrenador era: " + e.getNombre() + " " + e.getApe1());
				} catch (NumberFormatException nme) {
					System.out.println("Introduzca un número correcto para el código");
				}

				break;
			default:

				System.out.println("Introduzca 1, 2, 3 o 4");

			}

		} catch (NumberFormatException nfe) {

			System.out.println("Introduzca un número, no una letra, gracias");

		}

	}

	private static void modificarJugador() {
		mostrarEntrenador(contEntre);

		try {

			System.out.println("¿A qué entrenador desea modificar?");
			int codigo = teclado.nextInt();

			Entrenador e2 = contEntre.findByPK(codigo);

			System.out.println("¿Qué desea cambiar?\n" + "1.Código de entrenador\n" + "2.DNI\n" + "3.Nombre\n"
					+ "4.1er Apellido\n" + "5.2do Apellido\n" + "6.Equipo\n" + "7.Todo");
			int opcion = teclado.nextInt();

			switch (opcion) {

			// Cambia el código
			case 1:

				try {

					System.out.println("¿Qué codigo desea ponerle?");
					int codigoNuevo = teclado.nextInt();
					e2.setCodentrenador(codigoNuevo);

				} catch (NumberFormatException nfe) {

					System.out.println("Inserte un número para el código válido");

				}

				contEntre.modificarPersonas(e2);
				break;

			// Cambia DNI
			case 2:

				System.out.println("¿Qué DNI quiere ponerle?");
				String dniModificado = teclado.next();
				e2.setDni(dniModificado);

				contEntre.modificarPersonas(e2);

				break;

			// Cambia Nombre
			case 3:

				System.out.println("¿Qué nombre quiere ponerle?");
				String nombreModificado = teclado.next();
				e2.setNombre(nombreModificado);

				contEntre.modificarPersonas(e2);
				break;

			// Cambia 1er Apellido
			case 4:

				System.out.println("¿Qué primer apellido quiere ponerle?");
				String ape1Modificado = teclado.next();
				e2.setNombre(ape1Modificado);

				break;

			// Cambia 2do Apellido
			case 5:

				System.out.println("¿Qué segundo apellido quiere ponerle?");
				String ape2Modificado = teclado.next();
				e2.setNombre(ape2Modificado);

				break;

			// Cambia Todo
			case 7:
				Entrenador e7 = new Entrenador();
				try {

					System.out.println("Introduzca un código para el nuevo entrenador");
					int codentrenador = teclado.nextInt();
					e7.setCodentrenador(codentrenador);

				} catch (NumberFormatException nme) {
					System.out.println("Introduzca un número correcto para el código");
				}

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

			default:

				System.out.println("Elija una opción correcta");

			}
			// Modifica el contrato controladorCont.modificarContrato(t4);

			mostrarEntrenador(contEntre);
		} catch (NumberFormatException nme) {
			System.out.println("Introduzca un número correcto para el código");
		}
	}

	private static void mostrarEntrenador(ControladorEntrenador cen) {
		System.out.println("ENTRENADORES ---------------");
		for (Entrenador e : cen.findAll()) {
			System.out.println(e);
		}
	}

	public static void mostrarEquipo(ControladorEquipo ceq) {
		System.out.println("EQUIPOS ---------------");
		for (Equipo e : ceq.findAll()) {
			System.out.println(e);
		}
	}

	public static void mostrarJugador(ControladorJugador cj) {
		System.out.println("JUGADORES ---------------");
		for (Jugador j : cj.findAll()) {
			System.out.println(j);
		}
	}

	public static void main(String[] args) {
		menu();
	}

}
