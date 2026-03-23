package examenPOO;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ListadoEmpleados lista = new ListadoEmpleados();

		int opcion;

		do {
			System.out.println(" == Gestión de Empleados Avanzada == ");
			System.out.println("1. Añadir empleado");
			System.out.println("2. Listar empleados");
			System.out.println("3. Buscar por DNI");
			System.out.println("4. Modificar horas extra");
			System.out.println("5. Modificar bonificación");
			System.out.println("6. Modificar precio hora extra");
			System.out.println("7. Eliminar empleado");
			System.out.println("8. Ver estadísticas");
			System.out.println("9. Salir");
			System.out.print("Opción: ");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {

			case 1: // Añadir empleado
				System.out.print("Dni: ");
				String dni = sc.nextLine().trim().toUpperCase();

				if (lista.buscarPorDni(dni) != null) {
					System.out.println("ERROR: ese dni ya existe.");
					break;
				}

				System.out.print("Nombre y Apellidos: ");
				String nombreApellido = sc.nextLine();

				System.out.print("Salario Base: ");
				double salarioBase = sc.nextDouble();
				sc.nextLine();

				System.out.println("Horas extras realizadas: ");
				int horasExtrasRealizadas = sc.nextInt();

				double porcentaje = -1;
				while (porcentaje < 0 || porcentaje > 30) {
					System.out.print("Porcentaje de bonificación  (0-30): ");
					porcentaje = sc.nextDouble();
					sc.nextLine();
					if (porcentaje < 0 || porcentaje > 30)
						System.out.println("ERROR: debe estar entre 0 y 30.");
				}

				Empleado nuevo = new Empleado(dni, nombreApellido, salarioBase, horasExtrasRealizadas, porcentaje);
				if (lista.añadirEmpleado(nuevo)) {
					System.out.println(" Empleado añadido correctamente.");
				}
				break;

			case 2: // Listar empleados
				lista.listarTodos();
				break;

			case 3: // Buscar empleado por DNI
				System.out.print("Dni a buscar: ");
				String buscar = sc.nextLine().trim().toUpperCase();
				Empleado encontrado = lista.buscarPorDni(buscar);
				if (encontrado != null) {
					System.out.println(encontrado);
				} else {
					System.out.println("Empleado no encontrado.");
				}
				break;
				
			case 4: // Modificar horas extras
				System.out.print("Dni: ");
				dni = sc.nextLine().trim().toUpperCase();

				System.out.print("Nuevas horas extra: ");
				int horas = sc.nextInt();
				sc.nextLine();
				if (lista.modificarHorasExtra(dni, horas)) {
					System.out.println("Horas extra actualizadas correctamente.");
				} else {
					System.out.println("ERROR: vehículo no encontrado.");
				}
				break;

			case 5: // Modificar bonificación
				System.out.print("DNI: ");
				dni = sc.nextLine().trim().toUpperCase();
				if (lista.buscarPorDni(dni) == null) {
					System.out.println("ERROR: Empleado no encontrado.");
					break;
				}
				double nuevoPorcentaje = -1;
				while (nuevoPorcentaje < 0 || nuevoPorcentaje > 30) {
					System.out.print("Nuevo porcentaje (0-30): ");
					nuevoPorcentaje = sc.nextDouble();
					sc.nextLine();
					if (nuevoPorcentaje < 0 || nuevoPorcentaje > 30)
						System.out.println("ERROR: debe estar entre 0 y 30.");
				}
				lista.modificarBonificacion(dni, nuevoPorcentaje);
				System.out.println("Bonificación actualizada.");
				break;

			case 6: // Modificar precio hora extra
				System.out.print("Nuevo precio de las horas extra: ");
				double nuevoPrecioHorasExtra = sc.nextDouble();
				sc.nextLine();
				Empleado.setPrecioHoraExtra(nuevoPrecioHorasExtra);
				System.out.println(" Precio de las horas extra actualizado para todos los empleados.");
				break;

			case 7: // Eliminar empleado
				System.out.print("Dni a eliminar: ");
				String dniElim = sc.nextLine().trim().toUpperCase();
				if (lista.eliminarPorDni(dniElim)) {
					System.out.println(" Empleado eliminado correctamente.");
				} else {
					System.out.println("ERROR: empleado no encontrado.");
				}
				break;

			case 8: // Ver estadísticas
				System.out.println("\n--- ESTADÍSTICAS ---");
				System.out.printf("Ingreso ", lista.calcularGastoBonificaciones());
				System.out.println("\nEmpleado con alto desempeño  (bonificaciones > 15%):");
				lista.listarEmpleadosAltoDesempenio();
				break;
				
			case 9: // Salir
				System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
				break;
				
			default:
				System.out.println("Opción no válida. Elige entre 1 y 9.");
			}
			
		} while (opcion != 9);

		sc.close();

	}
}
