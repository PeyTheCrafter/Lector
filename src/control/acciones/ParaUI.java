package control.acciones;

import modelo.Libro;
import modelo.Pagina;
import modelo.acceso.GestorLibro;
import vista.UI;

public class ParaUI extends UI {
	private Libro libro;
	private GestorLibro gestor;
	private final int filas = 30;
	private final int columnas = 47;
	private final int caracteres = this.filas * this.columnas;
	private MALAvanzar listenetAvanzar = new MALAvanzar(this);
	private MALMarcar listenerMarcar = new MALMarcar(this);
	private MALRetroceder listenerRetroceder = new MALRetroceder(this);
	private MALIrAMarca listenerIrAMarca = new MALIrAMarca(this);

	public ParaUI() {
		super();
		this.libro = new Libro();
		this.libro.setIncremento(caracteres);
		this.libro.irAMarca();
		this.gestor = new GestorLibro(libro.getLectura());
		this.btnAvance.addActionListener(this.listenetAvanzar);
		this.btnMarcar.addActionListener(listenerMarcar);
		this.btnRetroceso.addActionListener(listenerRetroceder);
		this.btnIrAMarca.addActionListener(listenerIrAMarca);
		actualizarVentana();
	}

	public void actualizarVentana() {
		Pagina pagina = this.libro.getPaginas().get(this.libro.getPaginas().size() - 1);
		System.out.println(pagina.getPrimer() + " " + pagina.getUltimo());
		this.txtLector.setText(new GestorLibro(this.libro.getLectura()).getTexto().substring((int) pagina.getPrimer(),
				(int) pagina.getUltimo()));
		this.txtDebug.setText(String.valueOf(this.libro.getActual()));
	}

	public Libro getLibro() {
		return libro;
	}
}
