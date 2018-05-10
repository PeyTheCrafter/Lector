package modelo;

import java.util.ArrayList;

import modelo.acceso.GestorLibro;
import modelo.acceso.GestorMarca;

public class Libro implements Legible {
	private String lectura;
	private int actual = 0;
	private int marca = 0;
	private int incremento; // Incremento de caracteres por página.
	private ArrayList<Pagina> paginas;

	public Libro() {
		super();
		lectura = "src/datos/txt.txt";
		paginas = new ArrayList<>();
	}

	@Override
	public void avanzarPagina() {
		if (!comprobarUltimaPagina()) {
			cargarSiguientePagina();
		}
	}

	/**
	 * Comprueba si la página actual es la última o no. [Longitud del texto /
	 * incremento por página]
	 * 
	 * @return true si es la útima página, false si no.
	 */
	private boolean comprobarUltimaPagina() {
		boolean ult = new GestorLibro(this.lectura).getTexto().length() / this.incremento == this.actual;
		return ult;
	}

	/**
	 * Carga la siguiente página. Crea un página cuyos parámetros son los índices de
	 * los caracteres calculados y la introduce en el arrayList.
	 */
	private void cargarSiguientePagina() {
		this.actual++;
		this.paginas.add(new Pagina(this.actual * incremento, this.actual * incremento + incremento));
		int dif = calcularDiferenciaAvance();
		if (dif > 0) {
			escalarPagina(dif);
		}
	}

	/**
	 * Cuando se carga la última página normalmente no se llena (el número de
	 * caracteres de la página es superior al de caracteres restantes del texto.
	 * Este método establece el índice final de la página al índice final menos la
	 * diferencia que hay entre el número de caracteres que caben en la página y los
	 * restantes del texto.
	 * 
	 * @param dif
	 *            La diferencia calculada entre los caracteres que caben en la
	 *            página y los restantes del texto.
	 */
	private void escalarPagina(int dif) {
		this.paginas.get(this.paginas.size() - 1)
				.setUltimo(this.paginas.get(this.paginas.size() - 1).getUltimo() - dif);
	}

	/**
	 * Calcula la diferencia de los caracteres que caben en la página con los
	 * restantes del texto.
	 * 
	 * @return la diferencia calculada.
	 */
	private int calcularDiferenciaAvance() {
		int dif = (int) (this.paginas.get(this.paginas.size() - 1).getUltimo()
				- new GestorLibro(this.lectura).getTexto().length());
		return dif;
	}

	@Override
	public void retrocederPagina() {
		if (!comprobarPrimeraPagina()) {
			cargarAnteriorPagina();
		}
	}

	/**
	 * Comprueba si la página actual es la primera.
	 * 
	 * @return true si lo es, false si no.
	 */
	private boolean comprobarPrimeraPagina() {
		boolean pri = this.actual == 0;
		return pri;
	}

	/**
	 * Carga la página anterior.
	 */
	private void cargarAnteriorPagina() {
		this.actual--;
		this.paginas.add(new Pagina(this.actual * incremento, this.actual * incremento + incremento));
	}

	@Override
	public void marcarPagina() {
		new GestorMarca().guardar(this.actual);
	}

	@Override
	public void irAMarca() {
		this.actual = new GestorMarca().cargar();
		System.out.println(this.actual);
		this.paginas.add(new Pagina(this.actual * incremento, this.actual * incremento + incremento - 1));
	}

	public String getLectura() {
		return lectura;
	}

	public int getActual() {
		return actual;
	}

	public int getMarca() {
		return marca;
	}

	public ArrayList<Pagina> getPaginas() {
		return paginas;
	}

	public void setIncremento(int incremento) {
		this.incremento = incremento;
	}
}
