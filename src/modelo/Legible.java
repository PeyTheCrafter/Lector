package modelo;

public interface Legible {
	/**
	 * Carga la siguiente página.
	 */
	public void avanzarPagina();

	/**
	 * Carga la página anterior.
	 */
	public void retrocederPagina();

	/**
	 * Marca la página actual.
	 */
	public void marcarPagina();

	/**
	 * Va a la página marcada (si existe).
	 */
	public void irAMarca();
}
