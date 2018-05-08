package modelo;

public interface Legible {
	/**
	 * Carga la siguiente p�gina.
	 */
	public void avanzarPagina();

	/**
	 * Carga la p�gina anterior.
	 */
	public void retrocederPagina();

	/**
	 * Marca la p�gina actual.
	 */
	public void marcarPagina();

	/**
	 * Va a la p�gina marcada (si existe).
	 */
	public void irAMarca();
}
