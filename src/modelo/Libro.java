package modelo;

import java.util.ArrayList;

public class Libro implements Legible {
	private String lectura;
	private String texto;

	private int actual = 0;
	private int marca = 0;
	private ArrayList<Pagina> paginas;

	public Libro() {
		super();
		lectura = "src/modelo/txt.txt";
		paginas = new ArrayList<>();
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
		return this.paginas.get(this.actual + 1).getUltimo() == this.texto.length() - 1;
	}

	@Override
	public void retrocederPagina() {
		// TODO Auto-generated method stub

	}

	@Override
	public void marcarPagina() {
		// TODO Auto-generated method stub

	}

	@Override
	public void irAMarca() {
		// TODO Auto-generated method stub

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
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
