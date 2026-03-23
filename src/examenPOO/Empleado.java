package examenPOO;

/**
 * Representa un empleado 
 * Gestiona los datos del empleado
 *
 * @author Alvaro Vizuete
 * @version 1.0
 */
public class Empleado {

	private String dni;
	private String nombreApellidos;
	private double salarioBase;
	private int horasExtrasRealizadas;
	private double bonificaciónPordesempeño;

	private static double precioHoraExtra = 3.0;

  /**
   * Crea un empleado con sus variables 
   * 
   * @param dni 
   * @param nombreApellidos
   * @param salarioBase
   * @param horasExtrasRealizadas
   * @param bonificaciónPordesempeño
   */
	public Empleado(String dni, String nombreApellidos, double salarioBase, int horasExtrasRealizadas,
			double bonificaciónPordesempeño) {
		super();
		this.dni = dni;
		this.nombreApellidos = nombreApellidos;
		this.salarioBase = salarioBase;
		this.horasExtrasRealizadas = horasExtrasRealizadas;
		this.bonificaciónPordesempeño = bonificaciónPordesempeño;
	}

	
	public String getDni() {
		return dni;
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public int getHorasExtrasRealizadas() {
		return horasExtrasRealizadas;
	}

	public double getBonificaciónPordesempeño() {
		return bonificaciónPordesempeño;
	}

	public static double getPrecioHoraExtra() {
		return precioHoraExtra;
	}

	// Setters

	public void setHorasExtrasRealizadas(int horasExtrasRealizadas) {
		this.horasExtrasRealizadas = horasExtrasRealizadas;
	}

	public void setBonificaciónPordesempeño(double porcentaje) {

		if (porcentaje >= 0 || porcentaje <= 30)
			this.bonificaciónPordesempeño = porcentaje;
	}

	public static void setPrecioHoraExtra(double precio) {
		precioHoraExtra = precio;
	}
	
	// Metodos
	
	public double getImporteBonificacion() {
		return  salarioBase * bonificaciónPordesempeño / 100.0; 
	}
	
	public double getImporteHorasExtras() {
		return horasExtrasRealizadas * precioHoraExtra;
	}
	
	public double getImporteTotal() {
		return salarioBase + getImporteBonificacion() + getImporteHorasExtras();
	}
	
	public boolean esAltoDesempeño() { return bonificaciónPordesempeño > 15; 
	
	}
	@Override
	public String toString() {
		return dni + " -- " + nombreApellidos + "\n " +
		"Salario Base: " + salarioBase + " | " + "Bonificacion: " + getImporteBonificacion() +
		"( " + bonificaciónPordesempeño + " ) " + "\n " +
		"Horas Extra: " + getHorasExtrasRealizadas() + " | " + "Total Bruto: " + getImporteTotal();	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Empleado)) return false;
		Empleado otro = (Empleado) obj;
		return this.dni.equalsIgnoreCase(otro.dni);
		}

	
	
	
	

}
