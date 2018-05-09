package modelo;

import java.util.ArrayList;

import modelo.acceso.GestorLibro;
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
	}

	@Override
	public void avanzarPagina() {
		if (!comprobarUltimaPagina()) {
			cargarSiguientePagina();
		}
	}

	private boolean comprobarUltimaPagina() {
		boolean ult = new GestorLibro(this.lectura).getTexto().length() / this.incremento == this.actual;
		System.out.println("Ult: " + ult);
		return ult;
	}

	private void cargarSiguientePagina() {
		this.actual++;
		this.paginas.add(new Pagina(this.actual * incremento, this.actual * incremento + incremento));
		int dif = calcularDiferenciaAvance();
		if (dif > 0) {
			escalarPagina(dif);
		}
	}

	private void escalarPagina(int dif) {
		this.paginas.get(this.paginas.size() - 1)
				.setUltimo(this.paginas.get(this.paginas.size() - 1).getUltimo() - dif);
	}

	private int calcularDiferenciaAvance() {
		int dif = (int) (this.paginas.get(this.paginas.size() - 1).getUltimo()
				- new GestorLibro(this.lectura).getTexto().length());
		return dif;
	}

	@Override
	public void retrocederPagina() {
		if(!comprobarPrimeraPagina()) {
			cargarAnteriorPagina();
		}
	}
	
	private boolean comprobarPrimeraPagina() {
		boolean pri = this.actual == 0;
		return pri;
	}
	
	private void cargarAnteriorPagina() {
		this.actual--;
		this.paginas.add(new Pagina(this.actual * incremento,  this.actual * incremento + incremento));
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
