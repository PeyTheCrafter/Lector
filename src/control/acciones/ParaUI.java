package control.acciones;

import modelo.Libro;
import modelo.acceso.Gestor;
import vista.UI;

public class ParaUI extends UI {
	private Libro libro;
	private Gestor gestor;
	private int tamanoPantalla;
	
	public ParaUI() {
		super();
		this.libro = new Libro();
		this.gestor = new Gestor(libro.getLectura());
		this.tamanoPantalla = this.calcularTamanoPantalla();
	}
	
	private int calcularTamanoPantalla() {
		this.txtLector.setText(" ");
		int alto = this.txtLector.getHeight();
		int ancho = this.txtLector.getWidth();
		int altoFuente = this.txtLector.getFontMetrics(this.txtLector.getFont()).getHeight();
		int filas = alto / altoFuente;
		int tamano = ancho * filas;
		System.out.println(alto + ", " + ancho + ", " + altoFuente + ", " + filas + ", " + tamano);
		return tamano;
	}
}
