package control.acciones;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import modelo.Libro;
import modelo.acceso.Gestor;
import vista.UI;

public class ParaUI extends UI {
	private Libro libro;
	private Gestor gestor;
	private int tamanoPantalla;
	
	public ParaUI() {
		super();
		asd();
		this.tamanoPantalla = calcularTamanoPantalla();
		this.libro = new Libro();
		this.gestor = new Gestor(libro.getLectura());
	}
	
	private void asd() {
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println();
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private int calcularTamanoPantalla() {
		System.out.println(this.txtLector);
		int alto = this.txtLector.getHeight();
		int ancho = this.txtLector.getWidth();
		int altoFuente = this.txtLector.getFontMetrics(this.txtLector.getFont()).getHeight();
		int filas = alto / altoFuente;
		int tamano = ancho * filas;
		System.out.println(alto + ", " + ancho + ", " + altoFuente + ", " + filas + ", " + tamano);
		return tamano;
	}
}
