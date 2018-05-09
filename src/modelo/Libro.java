package modelo;

import java.util.ArrayList;

import modelo.acceso.GestorMarca;

public class Libro implements Legible {
	private String lectura;

	private int actual = 0;
	private int marca = 0;
	private int incremento;
	private ArrayList<Pagina> paginas;

	public Libro() {
		super();
		lectura = "src/modelo/txt.txt";
		paginas = new ArrayList<>();
		irAMarca();
	}

	@Override
	public void avanzarPagina() {
		if (comprobarUltimaPagina()) {
			if (cargarSiguientePagina()) {
				this.actual++;
			}
		}
	}

	private boolean comprobarUltimaPagina() {
		return this.actual == this.paginas.size() - 1;
	}

	private boolean cargarSiguientePagina() {
		return true;
	}

	@Override
	public void retrocederPagina() {
		// TODO Auto-generated method stub

	}

	@Override
	public void marcarPagina() {
		new GestorMarca().guardar(this.actual);
	}

	@Override
	public void irAMarca() {
		if (this.marca != 0) {
			this.actual = new GestorMarca().cargar();
		}
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
