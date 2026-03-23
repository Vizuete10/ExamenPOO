package examenPOO;

import java.util.ArrayList;

/**
 * Gestion de empleados Permite añadir, buscar, modificar y eliminar empleados.
 *
 * @author Alvaro Vizuete
 * @version 1.0
 */
public class ListadoEmpleados {
	private ArrayList<Empleado> empleados;

	public ListadoEmpleados() {
		this.empleados = new ArrayList<>();
	}

	/**
	 * Funcion para añadir un empleado
	 * 
	 * @param e Empleado a añadir
	 * @return
	 */
	public boolean añadirEmpleado(Empleado e) {
		if (e == null || empleados.contains(e))
			return false;
		empleados.add(e);
		return true;
	}

	/**
	 * Funcion que permite Listar todos los empleados que haya
	 */
	public void listarTodos() {
		if (empleados.isEmpty()) {
			System.out.println("No hay empleados registrados.");
			return;
		}
		System.out.println("== LISTADO DE EMPLEADOS ==");
		for (Empleado v : empleados) {
			System.out.println(v);
			System.out.println("---");
		}
	}

	/**
	 * Funcion que buscar el empleado por dni
	 * 
	 * @param dni se le añade la variable dni del empleado que queremos buscar
	 * @return si lo encuntra devulve al empleado que es, si no devulve NULL
	 */
	public Empleado buscarPorDni(String dni) {
		for (Empleado v : empleados)
			if (v.getDni().equalsIgnoreCase(dni))
				return v; // Si se encuentra lo devuelve
		return null; // si no encuetra nada devuleve null
	}

	/**
	 * Funcion para modificar las horas extra que realiza un empleado. Primero se
	 * busca si existe el empleado por ese dni
	 * 
	 * @param dni   se le añade la variable dni del empleado al que queremos
	 *              modificar las horas extra.
	 * @param horas variable de las horas que que seran las horas extra
	 * @return si no existe ese empleado devuelve false, si las horas son cambiadas
	 *         correctamente se devuelve true.
	 */
	public boolean modificarHorasExtra(String dni, int horas) {
		Empleado e = buscarPorDni(dni);
		if (e == null || horas < 0)
			return false;
		e.setHorasExtrasRealizadas(horas);
		return true;

	}

	/**
	 * Funcion para modificar la bonificacion de un empleado
	 * 
	 * @param dni        se le añade la variable dni del empleado al que queremos
	 *                   modificar la bonificacion.
	 * @param porcentaje variable
	 * @return
	 */
	public boolean modificarBonificacion(String dni, double porcentaje) {
		Empleado e = buscarPorDni(dni);
		if (e == null || porcentaje < 0 || porcentaje > 30)
			return false;
		e.setBonificaciónPordesempeño(porcentaje);
		return true;
	}

	/**
	 * Elimina el empleado con el dni indicado.
	 *
	 * @param dni Dni a eliminar
	 * @return true si se eliminó, false si no existía
	 */
	public boolean eliminarPorDni(String dni) {
		Empleado e = buscarPorDni(dni);
		if (e == null)
			return false;
		empleados.remove(e);
		return true;
	}

	/**
	 * Calcula el gasto de las bonificaciones para todos lo empleados que haya
	 * 
	 * @return el total de gastos
	 */
	public double calcularGastoBonificaciones() {
		double total = 0;
		for (Empleado e : empleados)
			total += e.getImporteBonificacion();
		return total;
	}

	/**
	 * lista los empleados de alto desempeño
	 * 
	 */
	public void listarEmpleadosAltoDesempenio() {
		boolean hay = false;
		System.out.println("== Empleados con Alto Desempenio (bonificación > 15%) ==");
		for (Empleado e : empleados)
			if (e.esAltoDesempeño()) {
				System.out.println(e);
				System.out.println("---");
				hay = true;
			}
		if (!hay)
			System.out.println("No hay epleados con Alto Desempenio.");
	}

}
