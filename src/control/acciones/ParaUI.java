package control.acciones;

import modelo.Libro;
import modelo.acceso.GestorLibro;
import vista.UI;

public class ParaUI extends UI {
	private Libro libro;
	private GestorLibro gestor;
	private final int filas = 30;
	private final int columnas = 47;
	private final int caracteres = this.filas * this.columnas;

	public ParaUI() {
		super();
		this.libro = new Libro();
		this.libro.setIncremento(caracteres);
		this.gestor = new GestorLibro(libro.getLectura());
	}
}
