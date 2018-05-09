package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.acciones.ParaUI;

public class MALAvanzar implements ActionListener {
	ParaUI paraUI;

	public MALAvanzar(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getLibro().avanzarPagina();
		this.paraUI.actualizarVentana();
	}
}
