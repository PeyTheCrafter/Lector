package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import modelo.Legible;
import modelo.Libro;

class LegibleTest {

	Legible instancia;

	@Before
	public void setUp() {
		this.instancia = new Libro();
	}

	@Test
	void testAvanzarPagina() {
		int paginaActual = ((Libro) instancia).getActual();
		instancia.avanzarPagina();
		assertEquals(paginaActual + 1, ((Libro) instancia).getActual());
		// Queda por probar que no avance en la última página.
	}

	@Ignore
	void testRetrocederPagina() {
	}

	@Ignore
	void testMarcarPagina() {
		fail("Not yet implemented");
	}

	@Ignore
	void testIrAMarca() {
		fail("Not yet implemented");
	}

}
